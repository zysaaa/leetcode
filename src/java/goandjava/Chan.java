package goandjava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * channel
 * @param <E>
 */
public class Chan<E> {

    private final LinkedBlockingQueue<E> queue;

    public Chan() {
        queue = new LinkedBlockingQueue<>(1);
    }

    public Chan(int size) {
        queue = new LinkedBlockingQueue<>(size);
    }

    public static <T> Chan<T> make() {
        return new Chan<>();
    }

    public void in(E data) {
        try {
            queue.put(data);
        } catch (InterruptedException ite) {}
    }

    private boolean in(E data, long timeout, TimeUnit timeUnit) {
        try {
            return queue.offer(data, timeout, timeUnit);
        } catch (InterruptedException e) {
            return false;
        }
    }

    public Selected<E> inCase(E data, InAfter<E> inAfter) {
        return new InSelected<>(this, inAfter, data);
    }

    public Selected<E> outCase(OutAfter<E> outAfter) {

        return new OutSelected<>(this, outAfter);
    }


    public E out() {
        try {
            return queue.take();
        } catch (InterruptedException e) {}
        return null;
    }

    private E out(long timeout, TimeUnit timeUnit) {
        try {
            return queue.poll(timeout, timeUnit);
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static void go(Runnable runnable) {
        new Thread(runnable).start();
    }

    abstract static class Selected<T> {
        Chan<T> chan;
        After<T> after;
        long times;

        public Selected(Chan<T> chan, After<T> after) {
            this.chan = chan;
            this.after = after;
        }
        abstract SelectedResult<T> doSelect(long timout, TimeUnit timeUnit);
        boolean process(SelectedResult<T> selectedResult) {
            times++;
            return doProcess(selectedResult);
        }

        abstract boolean doProcess(SelectedResult<T> selectedResult);
    }

    static class SelectedResult<T> {
        boolean success;
    }

    static class OutSelectedResult<T> extends SelectedResult<T> {
        T outData;
    }

    static class InSelected<T> extends Selected<T> {
        T data;

        public InSelected(Chan<T> chan, After<T> after, T data) {
            super(chan, after);
            this.data = data;
        }

        @Override
        boolean doProcess(SelectedResult<T> result) {
            if (result.success) {
                ((InAfter<T>)after).after();
                return true;
            }
            return false;
        }

        @Override
        SelectedResult<T> doSelect(long timout, TimeUnit timeUnit) {
            boolean success = chan.in(data, timout, timeUnit);
            SelectedResult<T> selectedResult = new SelectedResult<>();
            selectedResult.success = success;
            return selectedResult;
        }
    }

    static class OutSelected<T> extends Selected<T> {
        public OutSelected(Chan<T> chan, After<T> after) {
            super(chan, after);
        }

        @Override
        boolean doProcess(SelectedResult<T> result) {
            if (result.success) {
                ((OutAfter<T>)after).after(((OutSelectedResult<T>)result).outData);
                return true;
            }
            return false;
        }

        @Override
        SelectedResult<T> doSelect(long timout, TimeUnit timeUnit) {
            T out = chan.out(timout, timeUnit);
            OutSelectedResult<T> selectedResult = new OutSelectedResult<>();
            selectedResult.outData = out;
            if (out != null) {
                selectedResult.success = true;
            }
            return selectedResult;
        }
    }

    public static <T> void select(Selected<T>... selecteds) {
        List<Selected<T>> list = Stream.of(selecteds).sorted((o1, o2) -> (int) (o1.times - o2.times)).collect(Collectors.toList());
        while (true) {
            for (Selected<T> selected : list) {
                if (selected.process(selected.doSelect(1, TimeUnit.NANOSECONDS))) {
                    return;
                }
            }
        }
    }

    interface After<T> {}

    interface InAfter<T> extends After<T> {
        void after();
    }

    interface OutAfter<T> extends After<T> {
        void after(T data);
    }

    public static void main(String[] args) throws InterruptedException {
        Chan<String> chan1 = make();
        Chan<String> chan2 = make();
        AtomicInteger a = new AtomicInteger();
        AtomicInteger b = new AtomicInteger();

        int times = 500;
        go(() -> {
            while (true) {
                chan1.in("a");
            }
        });
        go(() -> {
            while (true) {
                chan2.in("a");
            }
        });
        while (times -- > 0) {
            select(
                    // 这里，每次是new了一个新case，导致times无法生效，也就不能公平调度
                    // ????
                    // 如果把变量申明在外面，就没go那味了
                    // 如何解决？
                    chan1.outCase(data -> {
                        a.getAndIncrement();
                    }),
                    chan2.outCase(data -> {
                        b.getAndIncrement();
                    })
            );
        }
        System.out.println(a.get());
        System.out.println(b.get());
    }
}
