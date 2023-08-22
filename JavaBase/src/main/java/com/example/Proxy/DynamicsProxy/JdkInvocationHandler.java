package com.example.Proxy.DynamicsProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: JDK 动态代理，自定义处理逻辑
 * @author: muqingfeng
 * @date: 2023/8/22 22:22
 */
public class JdkInvocationHandler implements InvocationHandler {
    //代理中的真实对象
    private final Object target;

    public JdkInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method "+ method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method "+ method.getName());
        return result;
    }
}
