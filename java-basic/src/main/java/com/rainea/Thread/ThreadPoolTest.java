package com.rainea.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test1();
    }

    private static void test0() throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hello callaboe");
                return "1111";
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(futureTask.get());
    }

    private static void test1() throws InterruptedException, ExecutionException {
        ExecutorService queryPool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10), new NamedThreadFactory("QUERY"), new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(queryPool.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + "aa");
                    return Thread.currentThread().getName() + "aa";
                }
            }));

//            System.out.println("-----------");

//            if (i != 0 && i % 5 == 0) {
//                Thread.sleep(2000);
//            }
        }

        System.out.println("---------");
        System.out.println(((ThreadPoolExecutor) queryPool).getTaskCount());

        for (Future<String> future : list) {
            System.out.println(future.get());
        }

    }


    private static class NamedThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public NamedThreadFactory(String name) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + name + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }

    }
}
