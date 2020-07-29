package com.example.demo.patterns.builder;

/**
 * 创建者模式又叫建造者模式，是将一个复杂的对象的构建与它的表示分离，使
 * 得同样的构建过程可以创建不同的表示。创建者模式隐藏了复杂对象的创建过程，它把复杂对象的创建过程加以抽象，通过子类继承或者重载的方式，
 * 动态的创建具有复合属性的对象。
 * TODO 可以有效替代构造器重载多的类
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student.Builder()
                .age(23)
                .height(172.5)
                .setName("chen")
                .weight(130)
                .build();
        System.out.println(student.toString());
    }
}
