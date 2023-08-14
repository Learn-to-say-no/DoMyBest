package com.example.Base.Lazy;

/**
 * @description: 懒汉式-需要使用时才创建---加锁synchronized
 * @author: muqingfeng
 * @date: 2023/8/13 22:07
 */
public class LazyInstance {
    //声明一个私有静态成员变量，用于保存唯一实例
    private static LazyInstance lazyInstance;

    //私有构造方法，防止外部类创建实例
    private LazyInstance(){}

    /**
     * 懒汉式的线程不安全主要原因在于多个线程可以并发进入 getInstance() 方法，
     * 当 lazyInstance 还未被初始化时，多个线程可能同时判断 lazyInstance 为 null，
     * 导致多个线程同时创建实例，从而违背了单例模式的要求。
     */
    public static LazyInstance getInstance(){
        if(lazyInstance == null){
            lazyInstance = new LazyInstance();
        }
        return lazyInstance;
    }
}
