package com.cc.study.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作容器，线程安全和线程不安全
 *
 * @author chenc
 * @create 2019-08-12 16:49
 **/
public class SynBlockTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
//            new Thread(new unSafe(list)).start();
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }

}

class unSafe implements Runnable {
    List<String> list;

    public unSafe(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(Thread.currentThread().getName());
    }
}