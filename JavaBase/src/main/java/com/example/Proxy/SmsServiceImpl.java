package com.example.Proxy;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/21 21:22
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
