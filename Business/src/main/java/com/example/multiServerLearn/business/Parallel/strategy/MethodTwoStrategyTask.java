package com.example.multiServerLearn.business.Parallel.strategy;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.stereotype.Service;

@Service
public class MethodTwoStrategyTask implements IBaseTask{
    @Override
    public String getTaskType() {
        return "method2";
    }

    @Override
    public BaseRespDTO<Object> execute() {
        BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
        Integer integer = method2();
        respDTO.setKey("method2");
        respDTO.setData(integer);
        return respDTO;
    }

    private Integer method2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
