package com.example.Base.Hungry;

/**
 * @description: 饿汉式-直接创建对象，不存在线程安全问题
 * 写法简单： 在类加载的时候就完成实例化，避免了线程同步问题
 * 在类加载的时候完成实例化，没有达到Lazy Loading的效果。
 * 如果从未使用过这个实例，则会造成内存的浪费
 * @author: muqingfeng
 * @date: 2023/8/13 22:07
 */
public class HungryInstance {
    public static final HungryInstance instance = new HungryInstance();

    private HungryInstance(){}
}
