package com.example.MultiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/26 20:01
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s){
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.time= "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.time= "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return this.command;
    }
}
