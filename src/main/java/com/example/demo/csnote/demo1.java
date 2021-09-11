package com.example.demo.csnote;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName demo1
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/8/14 下午8:14
 * @Version 1.0
 **/
public class demo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                int result = 0;
//                for (int i = 0; i < 100; i++) {
//                    Thread.sleep(10);
//                    result += i;
//                }
//                return result;
//            }
//        });
//
//        Thread computeThread = new Thread(futureTask);
//        computeThread.start();
//
//        Thread otherThread = new Thread(() -> {
//            System.out.println("other task is running...");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        otherThread.start();
//        System.out.println(futureTask.get());
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(demo1::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 20) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
