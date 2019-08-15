package com.rainea.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * i++ 不是线程安全，想要线程安全使用{@link AtomicInteger}
 *
 * @author liulang
 * @date 2019-08-14
 */
public class CommonInt {
    private static volatile int i = 0;

    /**
     * int ++ 非线程安全
     */
    private static void intIncrease() {
        new Thread() {
            @Override
            public void run() {
                for (int j = 0; j< 100000; j++) {
                    i++;
                    System.out.println(i);
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int j = 0; j< 100000; j++) {
                    i++;
                    System.out.println(i);
                }

            }
        }.start();
    }

    /**
     * 原子操作类（使用cas（compare-and-set）技术）保证线程安全
     */
    private static void atomicIncrease() {
        AtomicInteger atomicInteger = new AtomicInteger(i);
        new Thread() {
            @Override
            public void run() {
                for (int j = 0; j< 100000; j++) {
                    atomicInteger.incrementAndGet();
                    System.out.println(atomicInteger.get());
                }

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int j = 0; j< 100000; j++) {
                    atomicInteger.incrementAndGet();
                    System.out.println(atomicInteger.get());
                }

            }
        }.start();
    }

    public static void main(String[] args) {
        atomicIncrease();
    }
}
