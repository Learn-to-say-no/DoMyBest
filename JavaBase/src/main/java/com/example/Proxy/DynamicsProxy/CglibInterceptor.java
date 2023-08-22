package com.example.Proxy.DynamicsProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 自定义MethodInterceptor
 * @author: muqingfeng
 * @date: 2023/8/22 22:42
 */
public class CglibInterceptor implements MethodInterceptor {

    /**
     *
     * @param o 被代理对象--需要增强的对象
     * @param method 被拦截的方法--需要增强的方法
     * @param objects 方法入参
     * @param methodProxy 用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method "+ method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method "+ method.getName());
        return object;
    }
}
