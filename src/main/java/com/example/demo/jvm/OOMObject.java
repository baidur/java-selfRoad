package com.example.demo.jvm;

public class OOMObject {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        byte[] arr = new byte[1000 * _1MB];
    }
}
