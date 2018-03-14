package com.rainea.Thread;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by liulang on 2018/3/14.
 */
public class ThreadTest1 extends Thread {
    private String name;
    public ThreadTest1(String name) {
        this.name=name;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



    public static void main(String[] args) {
        ThreadTest1 mTh1=new ThreadTest1("A");
        ThreadTest1 mTh2=new ThreadTest1("B");
        mTh1.start();
        mTh2.start();

        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        HashMap<String, String > hashMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();
        List<String> list1 = Collections.synchronizedList(list);

    }
}
