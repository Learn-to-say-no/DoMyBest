package com.example.multiServerLearn.business.Parallel.strategy;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.stereotype.Service;

@Service
public class MethodOneStrategyTask implements IBaseTask{
    @Override
    public String getTaskType() {
        return "method1";
    }

    @Override
    public BaseRespDTO<Object> execute() {
        BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
        Integer integer = method1();
        respDTO.setKey("method1");
        respDTO.setData(integer);
        return respDTO;
    }

    private Integer method1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
