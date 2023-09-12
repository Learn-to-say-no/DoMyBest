package com.example.Controller;


import com.example.Service.MulThreadDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/skill")
public class MulThreadDownController {

    @Autowired
    private MulThreadDownService service;

    @GetMapping("/downFileByMulThread")
    private Map<String, String> downFile(String url){
        return service.down(url);
    }
}
