package com.example.demo.thread.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ParallelRowMultiplier {

    public static void main(String[] args) {
        double[][] matrix1 = new double[1000][1000];
        double[][] matrix2 = new double[1000][1000];
        double[][] result = new double[matrix1.length]
                [matrix2[0].length];
        long startTime = System.currentTimeMillis();
        multiply(matrix1,matrix2,result);
        long endTime = System.currentTimeMillis();
        System.out.printf("Serial: %d%n",endTime - startTime);
//        for(int i = 0 ; i < result.length; i++){
//            for(int j = 0 ; j < result[0].length; j++){
//                System.out.print(result[i][j] + "   ");
//            }
//            System.out.println();
//        }
    }
    public static void multiply(double[][] matrix1, double[][]
            matrix2, double[][] result) {

        List<Thread> threads = new ArrayList<>();

        int rows = matrix1.length;

        for (int i = 0; i < rows; i++) {
            RowMultiplierTask task = new RowMultiplierTask(result,
                    matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);

            if (threads.size() % 100 == 0) {
                waitForThreads(threads);
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}