package com.example.multiServerLearn.business.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/9/16 17:46
 */

@PropertySource(value = {"classpath:other.properties"})
@Component
@ConfigurationProperties(prefix = "person")
public class MyAppConfig {
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyAppConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
