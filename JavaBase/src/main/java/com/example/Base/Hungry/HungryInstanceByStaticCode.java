package com.example.Base.Hungry;

/**
 *
 */
public class HungryInstanceByStaticCode {
    private static HungryInstanceByStaticCode instance;

    static {
        instance = new HungryInstanceByStaticCode();
    }

    private HungryInstanceByStaticCode(){}

    public static HungryInstanceByStaticCode getInstance(){
        return instance;
    }
}
