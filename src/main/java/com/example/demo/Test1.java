package com.example.demo;

import java.util.concurrent.locks.LockSupport;
import java.util.stream.IntStream;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75
 */
public class Test1 {

    private volatile static String flag = "Thread2,Thread3";

    private static int count = 1;

    private static int sum = 1;

    public static void main(String[] args) {
        Test1 test = new Test1();
        IntStream.range(1,4).forEach(e -> new Thread(() ->{
            String name = "Thread"+ e;
            for(int i = 1;i <= 25;i++){
                test.printNum(name);
            }
        }).start());
    }


    public synchronized void printNum(String name) {
        while (flag.contains(name)){
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            LockSupport.unpark(Thread.currentThread());
        }
        System.out.println(name+":"+sum);
        sum++;
        count ++;
        if(count == 6){
            if(name.equals("Thread1")){
                flag = "Thread1,Thread3";
            }
            if(name.equals("Thread2")){
                flag = "Thread1,Thread2";
            }
            if(name.equals("Thread3")){
                flag = "Thread2,Thread3";
            }
            count = 1;
        }
        LockSupport.park();
    }

}
