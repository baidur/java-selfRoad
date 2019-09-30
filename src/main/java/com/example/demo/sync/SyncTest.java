package com.example.demo.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SyncTest {

    private static int i = 0;
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = run("one");
        Thread thread2 = run("two");
        Thread thread3 = run("three");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread1.interrupt();

        System.out.println(thread1.isInterrupted());
        Lock lock = new ReentrantLock();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        IntStream.range(0,1000).forEach(i -> new Thread(() -> {
            lock.lock();
            try {
                IntStream.range(0,10000).forEach(j -> {
                    count++;
                });
            }finally {
                lock.unlock();
            }
            countDownLatch.countDown();
        }).start());
        countDownLatch.await();
        System.out.println(count);
    }
    private static Thread run(String str){
        return new Thread(() -> {
            synchronized(SyncTest.class){
                for(;i < 10;i++){
                    System.out.println(str+i);
                }
                System.out.println(str);
            }
        });
    }

}
