package com.cc.study.thread;

/**
 * Volatile用于修饰变量，目的是将变量立刻刷新到主存中
 * ※Cpu在繁忙时，不会将变量时时刷新到主存内
 *
 * @author chenc
 * @create 2019-08-15 21:51
 **/
public class VolatileDemo {
    private volatile static int num2 = 0;
    private static int num = 0;

    public static void main(String[] args) {
        withVolatile();
    }

    public static void noVolatile() {
        new Thread(() -> {
            // 使用死循环，让CPU处于繁忙的状态
            while (num == 0) {

            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
    }


    public static void withVolatile() {
        new Thread(() -> {
            // 使用死循环，让CPU处于繁忙的状态
            while (num2 == 0) {

            }

        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num2 = 1;
    }
}
