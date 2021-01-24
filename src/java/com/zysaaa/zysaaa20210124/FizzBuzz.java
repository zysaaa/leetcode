package com.zysaaa.zysaaa20210124;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @description: 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出 "buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 *   public FizzBuzz(int n) { ... }               // constructor
 *   public void fizz(printFizz) { ... }          // only output "fizz"
 *   public void buzz(printBuzz) { ... }          // only output "buzz"
 *   public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 *   public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 * 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 * 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 * 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/24 18:35
 */
public class FizzBuzz {

    private int n;

    private int num = 1;

    private Lock lock = new ReentrantLock();

    private Condition conditionfizz = lock.newCondition();
    private Condition conditionbuzz = lock.newCondition();
    private Condition conditionfizzbuzz = lock.newCondition();
    private Condition conditionnumber = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        try {

            while (true) {
                while (num % 3 == 0 && num % 5 != 0) {
                    printFizz.run();
                    num++;
                    conditionbuzz.signal();
                    conditionfizzbuzz.signal();
                    conditionnumber.signal();
                    if (num -1 == n) {
                        System.err.println("return4");
                        return;
                    }
                }

                conditionfizz.await();
                if (num -1 == n) {
                    System.err.println("return4");
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                while (num % 5 == 0 && num % 3 != 0) {
                    printBuzz.run();
                    num++;
                    conditionfizz.signal();
                    conditionfizzbuzz.signal();
                    conditionnumber.signal();
                    if (num -1 == n) {
                        System.err.println("return3");
                        return;
                    }
                }

                conditionbuzz.await();
                if (num -1 == n) {
                    System.err.println("return4");
                    return;
                }
            }

        } finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                while (num % 5 == 0 && num % 3 == 0) {
                    printFizzBuzz.run();
                    num++;
                    conditionfizz.signal();
                    conditionbuzz.signal();
                    conditionnumber.signal();
                    if (num -1 == n) {
                        System.err.println("return3");
                        return;
                    }
                }

                conditionfizzbuzz.await();
                if (num -1 == n) {
                    System.err.println("return2");
                    return;
                }
            }

        } finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                while (num % 5 != 0 && num % 3 != 0) {
                    printNumber.accept(num);
                    num++;
                    conditionfizz.signal();
                    conditionbuzz.signal();
                    conditionfizzbuzz.signal();
                    if (num -1 == n) {
                        System.err.println("return3");
                        return;
                    }
                }
                System.err.println("num 是" + num);

                conditionnumber.await();
                if (num -1 == n) {
                    System.err.println("return1");
                    return;
                }
            }

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(1);
        new Thread(() -> {
            try {
                fizzBuzz.number(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        System.out.println(value);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fizzBuzz.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("buzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizzbuzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
    }
}
