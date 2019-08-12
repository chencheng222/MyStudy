package com.cc.study.thread;

/**
 * @description 线程阻塞  插队，必须等运行结束才能继续执行
 * @author chenc
 * @create 2019-08-12 11:12
 **/
public class JoinThread {
    public static void main(String[] args) {

        new Thread(new Father()).start();
    }
}

class Father implements Runnable {

    @Override
    public void run() {
        System.out.println("老爸想抽烟，发现没有烟了。。");
        System.out.println("让儿子买去。。");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
        }

        System.out.println("开始抽烟。。。");
    }
}

class Son implements Runnable {

    @Override
    public void run() {
        System.out.println("看见一家游戏厅，进去。。");
        for (int i = 0; i < 10; i++) {
            System.out.println("玩了" + i + "秒");
        }
        System.out.println("赶紧买烟去。。。");
        System.out.println("买完回去");
    }
}