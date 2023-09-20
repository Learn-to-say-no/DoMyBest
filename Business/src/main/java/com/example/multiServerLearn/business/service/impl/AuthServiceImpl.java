package com.example.multiServerLearn.business.service.impl;

import com.example.multiServerLearn.business.config.MyAppConfig;
import com.example.multiServerLearn.business.domin.po.User;
import com.example.multiServerLearn.business.mapper.UserMapper;
import com.example.multiServerLearn.business.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    MyAppConfig myAppConfig;

    @Override
    public User getUserInfo() {
        List<User> users = userMapper.selectList(null);
        System.out.println(myAppConfig);
        return users.isEmpty() ? null : users.get(0);
    }

    @Override
    public Boolean testRedis() {
        User po = new User(2, "张三", 18);
        int obj = userMapper.insert(po);
        if(obj == 1){
            redisTemplate.opsForValue().set("user1",po);
        }

        return true;
    }
}
