package com.example.demo.patterns.singleton;

import java.util.stream.IntStream;

/**
 * 懒汉式，线程不安全问题
 */
public class LazyTest {

    private static LazyTest lazyTest = null;

    public static synchronized LazyTest getLazyTest(){
        if(lazyTest == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazyTest = new LazyTest();
        }
        return lazyTest;
    }

    public static void main(String[] args) {
        IntStream.range(0,10).forEach((e) -> new Thread(() -> System.out.println(LazyTest.getLazyTest() == LazyTest.getLazyTest())).start());
    }
}
