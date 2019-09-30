package com.example.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class SemaphoreTest {

    static final Semaphore semaphore = new Semaphore(50);

    private static int sussCount = 0;
    private static int failCount = 0;

//    public static void main(String[] args) throws InterruptedException {
//        Lock lock = new ReentrantLock();
//        CountDownLatch countDownLatch = new CountDownLatch(100);
//        IntStream.range(0,100).forEach(i ->new Thread(() ->{
//            lock.lock();
//            try {
//                seckill();
//            }finally {
//                lock.unlock();
//            }
//            countDownLatch.countDown();
//        }).start());
//    }

    public static void main(String[] args) {
        for(int i = 0;i < 1000;i++){
            new Thread(SemaphoreTest::seckill).start();
        }
    }

    private static void seckill(){
        if(!semaphore.tryAcquire()){
            System.out.println("failCount"+failCount++);
            return ;
        }
        try {
            Thread.sleep(100);
            System.out.println("sussCount"+sussCount++);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
