package com.example.Proxy.StaticProxy;

import com.example.Proxy.SmsService;

/**
 * @description: 需要针对每个目标类都单独创建一个代理类
 * @author: muqingfeng
 * @date: 2023/8/22 22:14
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }


    @Override
    public String send(String message) {
        //调用方法前，添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");
        return null;
    }
}
