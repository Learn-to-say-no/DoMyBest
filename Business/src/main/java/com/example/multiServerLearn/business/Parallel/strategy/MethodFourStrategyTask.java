package com.example.multiServerLearn.business.Parallel.strategy;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.stereotype.Service;

@Service
public class MethodFourStrategyTask implements IBaseTask{
    @Override
    public String getTaskType() {
        return "method4";
    }

    @Override
    public BaseRespDTO<Object> execute() {
        BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
        Integer integer = method4();
        respDTO.setKey("method4");
        respDTO.setData(integer);
        return respDTO;
    }

    private Integer method4() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
