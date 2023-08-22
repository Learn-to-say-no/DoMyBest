package com.example.Proxy.DynamicsProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/8/22 22:45
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz){
        //创建动态增强类
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new CglibInterceptor());
        //创建代理类
        return enhancer.create();
    }
}
