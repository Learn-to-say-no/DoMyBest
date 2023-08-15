package com.example.JVM;

/**
 * @description: 引用GC--循环引用，不能被GC回收器回收
 * @author: muqingfeng
 * @date: 2023/8/15 23:44
 */
public class ReferenceCountingGc {
    Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGc a1 = new ReferenceCountingGc();
        ReferenceCountingGc a2 = new ReferenceCountingGc();
        a1.instance = a2;
        a2.instance = a1;
        a1 = null;
        a2 = null;
    }
}
