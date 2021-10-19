package com.zysaaa.common;

public class Mianshi {

    private static int i = 0;
    private static Object lock = new Object();

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int temp = nums[i];
            while (j >=0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (i == 100) {
                        break;
                    }
                    if (i % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i++ + " [" + Thread.currentThread().getName() + "]");
                    lock.notify();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (i == 101) {
                        break;
                    }
                    if (i % 2 == 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i++ + " [" + Thread.currentThread().getName() + "]");
                    lock.notify();
                }
            }
        }).start();
        Thread.sleep(2000);
    }
}
