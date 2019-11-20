package com.example.demo.patterns.proxy;

public class CarProxy implements CarService{

    private CarService carService;

    public CarProxy(CarService carService) {
        this.carService = carService;
    }


    @Override
    public void start() {
        System.out.println("开锁");
        carService.start();
        System.out.println("加速");
    }

}
