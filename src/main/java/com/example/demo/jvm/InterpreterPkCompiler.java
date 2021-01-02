package com.example.demo.jvm;

import java.util.Date;

/**
 * 解释器模式：-Xint 20ms
 * 编译器模式：-Xcomp 2ms
 * 混合模式：-Xmixed 4ms
 */
public class InterpreterPkCompiler {



    public static void main(String[] args) {
        test();
    }

    private static void test(){
        Date afterDate = new Date(new Date().getTime() + 60000);

        System.out.println(afterDate);
    }
}
