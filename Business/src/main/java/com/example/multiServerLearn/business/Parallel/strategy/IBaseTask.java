package com.example.multiServerLearn.business.Parallel.strategy;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;

public interface IBaseTask {
    String getTaskType();

    BaseRespDTO<Object> execute();
}
