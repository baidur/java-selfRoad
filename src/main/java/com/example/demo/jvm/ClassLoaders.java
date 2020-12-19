package com.example.demo.jvm;

public class ClassLoaders {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(ClassLoaders.class.getClassLoader());
        System.out.println(ClassLoaders.class.getClassLoader().getParent());
        System.out.println(ClassLoaders.class.getClassLoader().getParent().getParent());
    }
}
