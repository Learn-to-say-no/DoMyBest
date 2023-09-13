package com.example.MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/28 23:09
 */
public class DepositTask {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        ExecutorService work = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            work.submit(new Runnable() {
                @Override
                public void run() {
                    account.deposit(1.0);
                }
            });
        }

        work.shutdown();

        // 打印最终余额
        System.out.println("最终余额: " + account.getBalance());
    }

}
