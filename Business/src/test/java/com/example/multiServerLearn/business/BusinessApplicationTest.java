package com.example.multiServerLearn.business;

import com.example.multiServerLearn.business.config.MyAppConfig;
import com.example.multiServerLearn.business.config.properties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/9/16 19:13
 */
@SpringBootTest
public class BusinessApplicationTest {
    @Autowired
    MyAppConfig config;

    @Autowired
    properties properties;

    @Test
    public void test(){
        System.out.println(config);
        System.out.println(properties.getPort());
    }
}
