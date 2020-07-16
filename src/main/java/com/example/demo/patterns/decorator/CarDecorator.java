package com.example.demo.patterns.decorator;

public class CarDecorator extends Decorator{

    public CarDecorator(MatchmakeEvent matchmakeEvent) {
        super(matchmakeEvent);
    }

    private void homePropertyInfo(){
        System.out.println("我有一辆法拉利，一辆宾利");
    }

    public void appearance(){
        this.homePropertyInfo();
        super.appearance();
    }
}
