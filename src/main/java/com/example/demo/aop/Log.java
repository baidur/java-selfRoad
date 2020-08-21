package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/** 使用@Component 把这个类纳入到Spring 容器，@Aspect 注解表示这个类是一个切面类 */
@Component
@Aspect
public class Log {
    /** 定义一个前置通知*/
    /** 匹配com.jas.aop 包及其子包下的所有方法 */
    @Before("execution(* com.example.demo..*.*(..))")
    public void log(){
        System.out.println("... before ...");
    }
}

