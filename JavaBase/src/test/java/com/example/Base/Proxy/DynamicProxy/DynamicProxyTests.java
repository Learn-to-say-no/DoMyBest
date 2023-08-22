package com.example.Base.Proxy.DynamicProxy;

import com.example.Proxy.DynamicsProxy.CglibProxyFactory;
import com.example.Proxy.DynamicsProxy.JdkProxyFactory;
import com.example.Proxy.SmsService;
import com.example.Proxy.SmsServiceImpl;
import org.junit.Test;

/**
 * @description: JDK 动态代理
 * @author: muqingfeng
 * @date: 2023/8/22 22:31
 */
public class DynamicProxyTests {

    @Test
    public void jdkTest(){
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }

    @Test
    public void cglibTest(){
        SmsService smsService = (SmsService) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        smsService.send("java");
    }
}
