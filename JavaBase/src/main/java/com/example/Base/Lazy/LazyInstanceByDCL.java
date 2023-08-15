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
    //可见行，禁止指令重排序
    //为什么要使用validate
    //new关键字创建对象不是原子操作，创建一个对象会经历以下的步骤：
    //1.在堆内存开辟内存空间
    //2.调用构造方法，初始化对象
    //3.引用变量指向堆内存空间
    //而为了提高性能，编译器和处理器会对代码执行顺序进行指令重排序
    //执行顺序可能变为132
    //132时，引用变量指向堆内存空间，这个对象不为null，但是没有初始化
    //其他线程有可能这个时候进入了getInstance的第一个(if(instance==null)) 判断不为null
    //导致错误使用了没有初始化的非null实例，这样就会出现异常，这个就是DCL失效问题
    private volatile static LazyInstanceByDCL instance;

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
