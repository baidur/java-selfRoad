package com.example.demo.patterns.proxy;

/**
 * 静态代理
 * 在代理模式中有三个角色，一是目标接口，二是目标对象，三是代理对象
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        CarService carService = new CarServiceImpl() ;
        CarProxy carProxy = new CarProxy(carService);
        carProxy.start();
    }
}
