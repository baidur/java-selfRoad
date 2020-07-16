package com.example.demo.patterns.decorator;

/**
 * 装饰器
 */
public abstract class Decorator extends MatchmakeEvent{

    private MatchmakeEvent matchmakeEvent;

    public Decorator(MatchmakeEvent matchmakeEvent){
        this.matchmakeEvent = matchmakeEvent;
    }

    public void appearance() {
        this.matchmakeEvent.appearance();
    }

    public void agree(String answer) {
        this.matchmakeEvent.agree(answer);
    }
}
