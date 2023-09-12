package com.example.Base.Hungry;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HungryInstanceTest {

    @Test
    public void test(){
        HungryInstance instance = HungryInstance.instance;
    }


    //使用反射的破坏单例
    @Test
    public void destructSingleByReflection() throws Exception {
        //获取空参构造方法
        Constructor<HungryInstance> constructor = HungryInstance.class.getDeclaredConstructor(null);
        //设置强制访问
        constructor.setAccessible(true);
        //创建实例
        HungryInstance instance = constructor.newInstance();
        System.out.println("反射创建的实例"+instance);
        System.out.println("正常创建的实例"+instance.getInstance());
        System.out.println("正常创建的实例"+instance.getInstance());
    }

}
