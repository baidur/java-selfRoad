package com.example.demo.jvm;

public class GC {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){
        testAllocation();
        System.gc();
    }

    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        System.gc();
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
        System.gc();
    }
}
