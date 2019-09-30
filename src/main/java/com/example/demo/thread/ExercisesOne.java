package com.example.demo.thread;

/**
 * 题目二：写两个线程，一个线程打印152，另一个线程打印AZ，打印顺序是12A34B...5152Z；
 */
public class ExercisesOne {

    private volatile static boolean flag = false;

    public static void main(String[] args) {
        ExercisesOne test = new ExercisesOne();
        new Thread(() ->{
            for(int i=1;i <= 26;i++){
                test.printNum(i);
            }
        }).start();
        new Thread(() ->{
            for(char i='A';i <= 'Z';i++){
                test.printChar(i);
            }
        }).start();
    }


    public synchronized void printNum(int i) {
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(i*2-1);
        System.out.print(i*2);
        flag = true;
        this.notify();
    }

    public synchronized void printChar(char i) {
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(i);
        flag = false;
        this.notify();
    }
}
