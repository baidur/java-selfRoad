package com.example.demo.sort;

import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = {5,3,1,7,8,2,6,6};
        sort(arr);
        Arrays.stream(arr).forEach((System.out::println));
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
