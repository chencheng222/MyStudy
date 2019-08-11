package com.cc.study.thread;

/**
 * @description: 模拟龟兔赛跑
 * @author: chenc
 * @create: 2019-08-11 17:06
 **/
public class Racer implements Runnable {
    private String winner;
    @Override
    public void run() {
        for (int steps = 1; steps<= 100; steps++) {
            System.out.println(Thread.currentThread().getName() + "==>" + steps);
            boolean isWin = this.getWinner(steps);
            if (isWin) {

                break;
            }
        }
    }

    private boolean getWinner(int step) {
        if (winner != null) {
            return true;
        }

        if (step == 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner:" + winner);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "Tortoies").start();
        new Thread(racer, "Rabbit").start();
    }
}
