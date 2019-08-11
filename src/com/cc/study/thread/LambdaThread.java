package com.cc.study.thread;

/**
 * @description: Lambda表达式简化线程（用一次）的使用
 * @author: chenc
 * @create: 2019-08-11 21:06
 **/
public class LambdaThread {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("aaa");
            }
        }).start();
    }
}
