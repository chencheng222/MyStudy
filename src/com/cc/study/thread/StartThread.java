package com.cc.study.thread;

/**
 * @author chenc
 */
public class StartThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("一边上课");
        }
    }

    public static void main(String[] args) {
        // 创建子类对象
        StartThread startThread = new StartThread();
        // 开启线程  start方法不保证立即运行，系统安排调度执行分配
        startThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("一边Coding");
        }
    }
}
