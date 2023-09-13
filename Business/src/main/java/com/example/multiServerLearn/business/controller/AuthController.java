package com.example.multiServerLearn.business.controller;


import com.example.multiServerLearn.business.domin.cto.RespDTO;
import com.example.multiServerLearn.business.domin.po.User;
import com.example.multiServerLearn.business.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/getUserInfo")
    public RespDTO<User> getUserInfo(){
        return new RespDTO<>(authService.getUserInfo());
    }

    @GetMapping("/testRedis")
    public RespDTO<Boolean> testRedis(){
        return new RespDTO<>(authService.testRedis());
    }
}
