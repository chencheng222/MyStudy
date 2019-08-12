package com.cc.study.thread;

/**
 * 守护线程 是为用户线程服务的，JVM停止不需要守护线程执行完毕
 * 默认：用户线程 JVM等待用户线程执行完毕才会停止
 *
 * @author chenc
 * @create 2019-08-12 14:29
 **/
public class DaemonThread {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();
        Thread t1 = new Thread(god, "God");
        // 将用户线程调整为守护线程
        t1.setDaemon(true);
        t1.start();
        new Thread(you, "you").start();

    }
}

class You implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 365 * 100; i++) {
            System.out.println("happy life");
        }

        System.out.println(".....");
    }
}

class God implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("bless you...");
        }
    }
}
