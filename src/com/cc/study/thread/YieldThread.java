package com.cc.study.thread;

/**
 * @description: yield礼让线程  直接进入就绪状态(释放资源，cpu重新调度)
 * @author: chenc
 * @create: 2019-08-12 10:59
 **/
public class YieldThread {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();


    }

    static class MyYield implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " yield start");
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + "yield end");
        }
    }
}
