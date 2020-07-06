package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    private static List<Integer> list = new ArrayList<>(5);

    private static void add(){
        list.add(7);
    }

    public static void main(String[] args) {
        list.add(5);
        list.add(6);
        list = Collections.unmodifiableList(list);
        add();
    }
}
