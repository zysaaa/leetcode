package com.zysaaa.zysaaa20210124;

/**
 * @description: 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 *
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用 second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:zysaaa
 * @date: 2021/1/24 19:51
 */
public class Foo {

    private volatile int status = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while (status != 0) {

        }
        printFirst.run();
        status = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (status != 1) {

        }
        printSecond.run();
        status = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (status != 2) {

        }
        printThird.run();
    }
}
