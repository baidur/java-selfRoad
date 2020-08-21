package com.example.demo.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class User {

    public void test(){
        System.out.println("aa");
    }
}
