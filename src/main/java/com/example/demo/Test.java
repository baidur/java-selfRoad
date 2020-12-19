package com.example.demo;
import java.util.*;
import com.example.demo.aop.User;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args){

        Test test = new Test();
        test.c();
    }

    public void c(){
        int i1 = 0;
        i1 = i1++;
        System.out.println(i1);
        int i2 = 0;
        i2 = ++i2;
        System.out.println(i2);
    }

    private  String a(){
        System.out.println(11);
        return "a";
    }

    private String b(){
       return "b" + a();
    }

}
