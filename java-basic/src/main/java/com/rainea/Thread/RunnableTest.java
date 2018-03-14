package com.rainea.Thread;

/**
 * Created by liulang on 2018/3/14.
 */
public class RunnableTest implements Runnable {
    private String name;

    public RunnableTest(String name) {
        this.name=name;
    }


    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new RunnableTest("C")).start();
        new Thread(new RunnableTest("D")).start();
    }
}
