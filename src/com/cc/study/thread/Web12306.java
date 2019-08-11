package com.cc.study.thread;

/**
 * @description: 模拟抢票
 * @author: chenc
 * @create: 2019-08-11 16:51
 **/
public class Web12306 implements Runnable {
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "->" + ticketNums--);
        }
    }

    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread t1 = new Thread(web12306, "黄牛甲");
        Thread t2 = new Thread(web12306, "黄牛乙");
        Thread t3 = new Thread(web12306, "黄牛丙");

        t1.start();
        t2.start();
        t3.start();
    }
}
