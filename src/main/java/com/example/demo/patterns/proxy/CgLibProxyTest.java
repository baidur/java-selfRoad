package com.example.demo.patterns.proxy;


import org.springframework.cglib.core.DebuggingClassWriter;

public class CgLibProxyTest {

    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        CarService proxy = (CarService) new CgLibBlogProxyFactory(new CarServiceImpl()).newInstance();
        proxy.start();
    }
}
