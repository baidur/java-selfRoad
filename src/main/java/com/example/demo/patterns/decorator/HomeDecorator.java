package com.example.demo.patterns.decorator;

public class HomeDecorator extends Decorator{

    public HomeDecorator(MatchmakeEvent matchmakeEvent) {
        super(matchmakeEvent);
    }

    private void homePropertyInfo(){
        System.out.println("我北京有5套房");
    }

    public void appearance(){
        this.homePropertyInfo();
        super.appearance();
    }
}
