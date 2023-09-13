package com.example.MultiThread;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/28 23:10
 */
public class BankAccount {
    private double balance = 0;

    public void deposit(double money){
        balance+=money;
    }

    public double getBalance(){
        return balance;
    }
}
