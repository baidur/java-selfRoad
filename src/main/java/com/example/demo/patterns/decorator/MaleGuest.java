package com.example.demo.patterns.decorator;

/**
 * 男嘉宾,被装饰对象
 */
public class MaleGuest extends MatchmakeEvent {
    @Override
    public void appearance() {
        System.out.println("本人,身高150cm,体重180斤,秃头");
    }

    @Override
    public void agree(String answer) {
        System.out.println("小姐姐是否愿意跟我交往:" + answer);
    }
}
