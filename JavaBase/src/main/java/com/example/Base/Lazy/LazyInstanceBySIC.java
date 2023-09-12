package com.example.Base.Lazy;

/**
 * @description: 懒汉式-需要使用时才创建---静态内部类 static inner class
 * 利用Java类加载机制，将实例的创建延迟到静态内部类的加载过程中。
 * 这种方式即保证了懒加载，又避免了线程不安全问题
 * @author: muqingfeng
 * @date: 2023/8/13 22:07
 */
public class LazyInstanceBySIC {
    private LazyInstanceBySIC() {
    }


    //静态内部类
    private static class InstanceHolder {
        //静态常量，类加载的时候初始化
        private static final LazyInstanceBySIC INSTANCE = new LazyInstanceBySIC();
    }

    public static LazyInstanceBySIC getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
