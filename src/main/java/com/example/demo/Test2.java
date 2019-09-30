package com.example.demo;

import java.util.stream.IntStream;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75
 */
public class Test2 {

    private volatile static String flag = "Thread2,Thread3";

    private static int count = 20;

    public static void main(String[] args) {
        Test2 test = new Test2();
        IntStream.range(1,10).forEach(e -> new Thread(() ->{
            String name = "Thread"+ e;
            test.printNum(name);
        }).start());
    }


    public void printNum(String name) {

            while (count > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+":"+count);
                count--;
            }

    }

}
