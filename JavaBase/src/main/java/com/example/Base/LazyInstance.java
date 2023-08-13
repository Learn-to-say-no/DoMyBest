package com.example.Base;

/**
 * @description: 懒汉式-需要使用时才创建
 * @author: muqingfeng
 * @date: 2023/8/13 22:07
 */
public class LazyInstance {
    //声明一个私有静态成员变量，用于保存唯一实例
    private static LazyInstance lazyInstance;

    //私有构造方法，防止外部类创建实例
    private LazyInstance(){}

    //公共静态方法，用于获取唯一实例
    //需要使用synchronized 防止线程安全问题
    public static synchronized LazyInstance getInstance(){
        if(lazyInstance == null){
            lazyInstance = new LazyInstance();
        }
        return lazyInstance;
    }
}
