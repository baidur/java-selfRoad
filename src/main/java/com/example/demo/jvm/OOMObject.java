package com.example.demo.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.List;

public class OOMObject {

    public OOMObject(){
        byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();

        for(int i = 0;i < num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }

    }
    public static void createBusyThread(){
        new Thread(() ->{
            while (true);
        },"aa").start();
    }

    public static void createLockThread(final Object lock){
        new Thread(() ->{
            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"bb").start();
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);
    }
}
