package com.example.Base.Hungry;

/**
 *
 */
public class HungryInstanceByGet {
    private static final HungryInstanceByGet instance = new HungryInstanceByGet();

    private HungryInstanceByGet(){}

    public static HungryInstanceByGet getInstance(){
        return instance;
    }
}
