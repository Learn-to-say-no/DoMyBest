package com.example.Base.Lazy;

import com.example.Base.Lazy.LazyInstance;
import com.example.Base.Lazy.LazyInstanceBySynchronized;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/13 22:10
 */
public class LazyInstanceTest {


    Logger LOG = LoggerFactory.getLogger(getClass());


    @Test
    public void getInstance() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                LazyInstance instance = LazyInstance.getInstance();
                System.out.println("多线程创建的单例: "+instance);
            }).start();
        }

    }

    @Test
    public void getInstanceBySynchronized() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                LazyInstanceBySynchronized instance = LazyInstanceBySynchronized.getInstance();
                System.out.println(instance);
            });
//            threads.add(thread);
            thread.start();
        }
    }
}
