package com.example.multiServerLearn.business.Parallel.strategy;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.stereotype.Service;

@Service
public class MethodThreeStrategyTask implements IBaseTask{
    @Override
    public String getTaskType() {
        return "method3";
    }

    @Override
    public BaseRespDTO<Object> execute() {
        BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
        Integer integer = method3();
        respDTO.setKey("method3");
        respDTO.setData(integer);
        return respDTO;
    }

    private Integer method3() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
