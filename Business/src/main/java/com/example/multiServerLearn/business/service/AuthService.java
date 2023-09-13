package com.example.multiServerLearn.business.service;

import com.example.multiServerLearn.business.domin.po.User;

public interface AuthService {
    User getUserInfo();

    Boolean testRedis();
}
