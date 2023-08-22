package com.example.Base.Proxy.StaticProxy;

import com.example.Proxy.StaticProxy.SmsProxy;
import com.example.Proxy.SmsService;
import com.example.Proxy.SmsServiceImpl;
import org.junit.Test;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/22 22:16
 */
public class StaticProxyTests {

    @Test
    public void getMessage(){
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
