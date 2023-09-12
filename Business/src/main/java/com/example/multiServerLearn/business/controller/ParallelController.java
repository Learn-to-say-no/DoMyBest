package com.example.multiServerLearn.business.controller;

import com.example.multiServerLearn.business.domin.cto.RespDTO;
import com.example.multiServerLearn.business.service.ParallelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Parallel")
public class ParallelController {

    @Autowired
    private ParallelService parallelService;



    @GetMapping("/testNeedTime")
    public RespDTO<Boolean> testNeedTime(){
        return new RespDTO<>(parallelService.testNeedTime());
    }


    //抽取公共方法后的并行
    @GetMapping("/testNeedTimeByCommand")
    public RespDTO<Boolean> testParallelMethod(){
        return new RespDTO<>(parallelService.testParallelMethod());
    }

}
