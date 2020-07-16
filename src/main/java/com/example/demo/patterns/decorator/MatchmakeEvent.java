package com.example.demo.patterns.decorator;

/**
 * 相亲大会
 */
public abstract class MatchmakeEvent {

    /**
     * 外貌
     */
    public abstract void appearance();

    /**
     * 是否愿意交往
     */
    public abstract void agree(String answer);
}
