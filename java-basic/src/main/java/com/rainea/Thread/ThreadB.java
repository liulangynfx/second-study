package com.rainea.Thread;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        WaitTest service = new WaitTest();
        service.synNotifyMethod(lock);
    }
}
