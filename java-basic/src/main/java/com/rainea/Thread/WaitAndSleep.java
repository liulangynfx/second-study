package com.rainea.Thread;

/**
 * 测试wait(),notify()，及Thread.sleep()的作用
 */
public class WaitAndSleep {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        ThreadB c = new ThreadB(lock);
        c.start();
    }

    /**
     * 线程A
     */
    static class ThreadA extends Thread {
        private Object lock;

        public ThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            WaitService service = new WaitService();
            service.testMethod(lock);
        }
    }

    /**
     * 线程B
     */
    static class ThreadB extends Thread {
        private Object lock;

        public ThreadB(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            WaitService service = new WaitService();
            service.synNotifyMethod(lock);
        }
    }

    /**
     * service，包含两个方法，分别供ThreadA和ThreadB调用
     */
    static class WaitService {

        public void testMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
                    //如果当前线程不是lock1对象锁的持有者，则当前线程会抛出 IllegalMonitorStateException 异常
//                Object lock1 = new Object();
//                lock1.wait(3000);
                    //释放调用对象的对象锁，并使当前线程等待,知道被通知或者超过3s，然后重新争取获得对象锁
                    lock.wait(3000);
//                Thread.sleep(5000);
                    System.out.println("  end wait() ThreadName=" + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void synNotifyMethod(Object lock) {
            try {
                synchronized (lock) {
                    System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time="
                            + System.currentTimeMillis());
                    lock.notify();
                    Thread.sleep(5000);
                    System.out.println("  end notify() ThreadName=" + Thread.currentThread().getName() + " time="
                            + System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

