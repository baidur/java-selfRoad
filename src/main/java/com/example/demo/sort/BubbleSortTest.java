package com.example.demo.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = new int[100000];
        for(int i = 0;i < 100000;i++){
            arr[i] = new Random().nextInt(100);
        }
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
      //  Arrays.stream(arr).forEach((System.out::println));
    }

    public static int[] sort(int[] arr){
        for(int i=0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                int a = arr[i];
                int b = arr[j];
                int temp ;
                if(a > b){
                    temp = a;
                    arr[i] = b;
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
