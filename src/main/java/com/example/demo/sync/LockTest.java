package com.example.demo.sync;

import java.util.stream.IntStream;

public class LockTest {

    public static void main(String[] args) {
        Lock lock = new Lock();
        IntStream.range(0,10).forEach(i -> new Thread(() -> {
            test(i,lock);
        }).start());
    }

    public static void test(int i,Lock lock){
        lock.lock();
        try {
            IntStream.range(0,10).forEach(j -> {
                System.out.println("线程"+i+"->执行"+j);
            });
        }finally {
            lock.unlock();
        }
    }
}
