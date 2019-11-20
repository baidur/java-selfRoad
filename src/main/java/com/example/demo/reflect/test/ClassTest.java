package com.example.demo.reflect.test;

import com.example.demo.reflect.entity.User;
import com.example.demo.reflect.util.ClassUtils;

public class ClassTest {


    /**
     * java反射的基本用法， 它可以在运行时判断任意一个对象所属的类；
     * 在运行时构造任意一个类的对象；
     * 在运行时判断任意一个类所具有的成员变量和方法；
     * 在运行时调用任意一个对象的方法；生成动态代理。
     * @param args
     */
    public static void main(String[] args) {
        User user = new User();
        //ClassUtils.getMethods(user);
        //ClassUtils.getFields(user);
        ClassUtils.getMethod(user);
    }

}
