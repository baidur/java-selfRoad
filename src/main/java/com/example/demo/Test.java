package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String s = "aa";
        for (int i = 0; i < 10;i++){
            String aa = "a" + "b" + s;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i = 0 ; i < list.size();i++){
            list.remove(0);
        }

    }
}
