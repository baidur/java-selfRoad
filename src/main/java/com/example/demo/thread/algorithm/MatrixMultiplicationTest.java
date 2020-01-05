package com.example.demo.thread.algorithm;

import java.util.Arrays;

/**
 * 矩阵的相乘，它只有当左边矩阵的列数和右边矩阵的行数相同时才有意义比如AB
 *     int[][] matrix1 = {
 *                 {1,2,3},
 *                 {1,2,3},
 *                 {1,2,3},
 *                 {1,2,3}
 *         };
 *         int[][] matrix2 = {
 *                 {1,2,3,4},
 *                 {1,2,3,4},
 *                 {1,2,3,4}
 *         };
 */
public class MatrixMultiplicationTest {

    public static void main(String[] args)  {
        int[][] matrix1 = new int[1000][1000];
        int[][] matrix2 = new int[1000][1000];
        long startTime = System.currentTimeMillis();

        int[][] result = result(matrix1,matrix2);
//        for(int i = 0 ; i < result.length; i++){
//            for(int j = 0 ; j < result[0].length; j++){
//                System.out.print(result[i][j] + "   ");
//            }
//            System.out.println();
//        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Serial: %d%n",endTime - startTime);
    }

    private static int[][] result(int[][] matrix1, int[][] matrix2){
        int[][] result = new int[matrix1.length]
                [matrix2[0].length];
        for(int i = 0; i < matrix1.length; i++){
            int finalI = i;
            Thread thread = new Thread(() ->{
                for(int j = 0; j < matrix2[0].length; j++){
                    for(int z = 0; z < matrix2.length; z++){
                        result[finalI][j] = result[finalI][j] + matrix1[finalI][z] * matrix2[z][j];
                    }
                }
            });
//            thread.start();
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return result;
    }
}
