package com.example.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTest {

    private final static ArrayBlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(4);
    private final static RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.CallerRunsPolicy();
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,1000,TimeUnit.MINUTES,WORK_QUEUE,HANDLER);

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(i ->{
            threadPoolExecutor.execute(new Thread(() ->{
                System.out.println(i);
            },"tt"+i));
        });
    }
}
