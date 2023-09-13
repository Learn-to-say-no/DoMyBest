package com.example.MultiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/26 20:06
 */
public class ThreadPoolExecutorsDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            MyRunnable worker = new MyRunnable("" + i);
            //执行
            executor.submit(worker);
        }
        executor.shutdown();
        while(!executor.isTerminated()){
        }

        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("线程数："+i);
        System.out.println("Finished all threads");
    }

}
