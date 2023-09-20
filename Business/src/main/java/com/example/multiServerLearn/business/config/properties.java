package com.example.multiServerLearn.business.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: some desc
 * @author: muqingfeng
 * @date: 2023/9/16 19:01
 */
@Component
@ConfigurationProperties(prefix = "server")
public class properties {
    private Integer port;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
