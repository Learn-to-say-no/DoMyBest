package com.example.Base.Lazy;

/**
 * @description: 懒汉式-需要使用时才创建---双重检查锁定 Double-Checked Locking
 * 在方法内使用两次检查，首先判断 instance 是否已经被创建
 * 如果没有， 则进入同步块，再次判断是否为null
 * 如果是，才创建实例。
 * 这种方式避免了每次都获取锁，提高了性能
 * @author: muqingfeng
 * @date: 2023/8/13 22:10
 */
public class LazyInstanceByDCL {
    private static LazyInstanceByDCL instance;

    private LazyInstanceByDCL(){}

    public static LazyInstanceByDCL getInstance(){
        if(instance == null){
            synchronized (LazyInstanceByDCL.class){
                if(instance == null){
                    instance = new LazyInstanceByDCL();
                }
            }
        }
        return instance;
    }
}
