package com.example.Concurrency;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolExecutor 用法
 */
public class ThreadPoolExecutorUsage {

    public static void main(String[] args) {
        /* OOM
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }*/

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行");
            });
        }
    }

    private static void test(String s, boolean isGC) {
        try {
            new ThreadLocal<>().set(s);
            if(isGC){
                System.gc();
            }
            Thread t = Thread.currentThread();
            Class<? extends Thread> clz = t.getClass();
            Field field = clz.getDeclaredField("threadLocals");
            field.setAccessible(true);
            Object Thread = field.get(t);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
