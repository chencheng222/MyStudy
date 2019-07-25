package com.cc.study.thread;

import java.util.concurrent.*;

public class Call {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建线程
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Race race = new Race();

        // 获取值
        Future<Integer> future = executorService.submit(race);
        Integer result = future.get();
        System.out.println(result);
        // 停止服务
        executorService.shutdownNow(); // 立即停止。不管线程的执行状态
    }



    }
    class Race implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            return 100;
        }
}
