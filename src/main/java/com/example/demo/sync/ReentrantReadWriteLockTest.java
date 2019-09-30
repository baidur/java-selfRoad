package com.example.demo.sync;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    private ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private void read()  {
        readLock.lock();
        try {
            System.out.println("read开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            readLock.unlock();
            System.out.println("read结束");
        }
    }

    private void write()  {
        writeLock.lock();
        try {
            System.out.println("write开始");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            writeLock.unlock();
            System.out.println("write结束");
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest readWriteLockTest = new ReentrantReadWriteLockTest();
        new Thread(readWriteLockTest::read).start();
        new Thread(readWriteLockTest::write).start();
    }


}
