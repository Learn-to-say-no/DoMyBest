package com.example.Base.StringDesign;

import java.lang.reflect.Field;

/**
 * @description: 改变String的值
 * @author: muqingfeng
 * @date: 2023/8/23 22:22
 */
public class changeStringValue {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s = "Hydra";
        System.out.println(s + ": "+ s.hashCode());
        s = "Trunks";
        System.out.println(s + ": "+ s.hashCode());

        /*
        final 修饰引用数据类型时，就像String里的char[]，能够保证指向该数组对象的引用不能修改，但是数组里的值能够被修改
         */


        //如何修改String的值，使用反射
        Field field = String.class.getDeclaredField("value");
        //允许通过反射来访问私有字段、方法等，即取消来访问控制限制
        field.setAccessible(true);
        field.set(s,new char[]{'T','r','u','n','k','s'});
        System.out.println(s + ": "+ s.hashCode());
    }
}
