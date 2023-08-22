package com.example.Proxy.DynamicsProxy;

import java.lang.reflect.Proxy;

/**
 * @description: 获取代理对象的工厂类
 * @author: muqingfeng
 * @date: 2023/8/22 22:26
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        //主要通过Proxy.newProxyInstance()方法获取某个类的代理对象

        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标类的类加载器
                target.getClass().getInterfaces(), //代理需要实现的接口吗，可指定多个
                new JdkInvocationHandler(target) //代理对象对应的自定义 InvocationHandler
        );
    }
}
