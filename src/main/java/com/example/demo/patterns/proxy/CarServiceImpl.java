package com.example.demo.patterns.proxy;


public class CarServiceImpl implements CarService {

    @Override
    public void start(){
        System.out.println("汽车启动");
    }
}
