package com.rainea.Thread;

/**
 * Thread 和 runnable 的用法
 *
 * @author liulang
 * @date 2019-08-15
 */
public class ThreadAndRunnable {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("ThreadA running.");
            }
        };
        thread.start();

        Thread threadRunnable = new Thread(() -> {
            System.out.println("runnable is running");
        });
        threadRunnable.start();
    }


}
