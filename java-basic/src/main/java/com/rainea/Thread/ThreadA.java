package com.rainea.Thread;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        WaitTest service = new WaitTest();
        service.testMethod(lock);
    }
}

