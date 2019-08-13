package com.cc.study.thread;

/**
 * 多线程模拟在线购票
 *
 * 重点:Passenger类采用了代理模式，好处是购票类在运行时能够通过当前线程强转Passenger，从而取得
 * Passenger类中的其他属性。。
 *
 * @author chenc
 * @create 2019-08-13 21:47
 **/
public class Happy12306 {
    public static void main(String[] args) {
        WebHappy12306 happy12306 = new WebHappy12306(5, "happy12306");
        new Passenger(happy12306, "甲", 2).start();
        new Passenger(happy12306, "乙", 2).start();
    }
}

/**
 * 订票者
 * 采用代理模式，目的是将当前顾客的票数传给12306
 */
class Passenger extends Thread {
    int seats;

    public Passenger(Runnable target, String name, int seats) {
        super(target, name);
        this.seats = seats;
    }
}


/**
 * 12306
 */
class WebHappy12306 implements Runnable {
    // 可用座位数
    int available;
    // 名称
    String name;

    public WebHappy12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * 购票
     *
     * @param seats
     * @return
     */
    public synchronized boolean bookTickets(int seats) {
        System.out.println("可选座位数：" + available);
        if (seats > available) {
            // System.out.println("座位数不够，购票失败");
            return false;
        }
        available -= seats;
        return true;
    }

    @Override
    public void run() {

        // 运用代理，将当前线程->Passenger 中的票数（seats）取得
        Passenger passenger = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(passenger.seats);
        if (flag) {
            System.out.println("出票成功--" + Thread.currentThread().getName() + "-->位置数为：" + passenger.seats);
        } else {
            System.out.println("出票失败--" + Thread.currentThread().getName() + "-->位置数为：" + passenger.seats);
        }

    }
}
