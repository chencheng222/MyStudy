package com.cc.study.thread;

/**
 * 多线程模拟影院购票
 *
 * @author chenc
 * @create 2019-08-12 22:41
 **/
public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(2, "万达影院");
        new Thread(new Customer(cinema, 2), "张三").start();
        new Thread(new Customer(cinema, 1), "李四").start();
    }

}

/**
 * 顾客
 */
class Customer implements Runnable {
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功--" + Thread.currentThread().getName() + "-->位置数为：" + seats);
            } else {
                System.out.println("出票失败--" + Thread.currentThread().getName() + "-->位置数为：" + seats);
            }
        }
    }
}

class Cinema {
    // 可用座位数
    int available;
    // 名称
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * 购票
     *
     * @param seats
     * @return
     */
    public boolean bookTickets(int seats) {
        System.out.println("可选座位数：" + available);
        if (seats > available) {
            // System.out.println("座位数不够，购票失败");
            return false;
        }
        available -= seats;
        return true;
    }
}