package com.example.demo.jvm;

public class StackOverFlowError {

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        test();
    }
}
