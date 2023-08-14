package com.example.Base.Lazy;

/**
 * @description: 懒汉式-需要使用时才创建---加锁synchronized
 * @author: fanjj
 * @date: 2023/8/14 16:25
 */
public class LazyInstanceBySynchronized {
    //声明一个私有静态成员变量，用于保存唯一实例
    private static LazyInstanceBySynchronized instance;

    //私有构造方法，防止外部类创建实例
    private LazyInstanceBySynchronized(){}

    //公共静态方法，用于获取唯一实例
    //需要使用synchronized 防止线程安全问题
    //但是会引入性能开销，因为每次调用getInstance()都需要获取锁，即使实例已经创建
    public static synchronized LazyInstanceBySynchronized getInstance(){
        if(instance == null){
            instance = new LazyInstanceBySynchronized();
        }
        return instance;
    }
}
