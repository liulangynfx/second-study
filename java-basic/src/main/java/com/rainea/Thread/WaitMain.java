package com.rainea.Thread;

public class WaitMain {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        //NotifyThread notifyThread = new NotifyThread(lock);
        // notifyThread.start();

        ThreadB c = new ThreadB(lock);
        c.start();
    }
}
