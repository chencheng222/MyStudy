package com.cc.study.thread.Cooperation;

/**
 * 协作模式：生产者消费者实现->管程法
 *
 * 要点：
 * 1.生产者->往容器中存放数据
 * 2.消费者->从容器中取数据
 * 3.容器->存放数据对象
 * 4.数据对象
 *
 * @author chenc
 * @create 2019-08-15 19:46
 **/
public class PipeLine {

    public static void main(String[] args) {
        Container container = new Container();
        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    Container container;

    public Producer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println("生产了第" + i + "个馒头");
            container.push(new Data(i));
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    Container container;

    public Consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            System.out.println("消费了了第" + container.pop().getId() + "个馒头");
        }
    }
}

/**
 * 容器
 */
class Container {
    // 定义容器大小
    Data[] dataContainer = new Data[10];
    // 计数器
    int count = 0;
    /**
     * 存数据
     * @param data
     */
    public synchronized void push(Data data) {
        // 当容器中存在空间时，才能存放，否则等待消费
        if (count == dataContainer.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        dataContainer[count++] = data;
        // 唤起消费者消费
        this.notifyAll();
    }

    /**
     * 取出数据
     * @return
     */
    public synchronized Data pop() {
        // 当容器中没有数据时，停止消费，等待生产
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Data data =  dataContainer[--count];
        // 唤醒生产
        this.notifyAll();
        return data;
    }

}

/**
 * 容器存放对象
 */
class Data {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data(int id) {
        this.id = id;
    }
}