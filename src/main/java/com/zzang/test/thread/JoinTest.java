package com.zzang.test.thread;

public class JoinTest {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("start trhead.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end trhead.");
            }
        };
        thread.start();

        try {
            // 스레드가 끝날때 까지 대기한다.
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread terminated.");
    }
}
