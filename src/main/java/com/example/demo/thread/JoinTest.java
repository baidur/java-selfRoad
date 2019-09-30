package com.example.demo.thread;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            System.out.println(111);
        });
        thread.start();

//        thread.join(111111);
        Thread thread1 = new Thread(() ->{
            System.out.println(1111);
        });
        thread1.start();

        Thread thread2 = new JoinThread(thread1);
        Thread thread3 = new JoinThread(thread2);
        thread2.start();
        thread3.start();
        System.out.println(11111);
    }
    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                synchronized (thread){
                    System.out.println(thread.getName() + " terminated.");
                    thread.wait(1000);
                    System.out.println(thread.getName() + " terminated.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
