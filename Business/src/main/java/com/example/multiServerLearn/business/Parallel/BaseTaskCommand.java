package com.example.multiServerLearn.business.Parallel;

import com.example.multiServerLearn.business.Parallel.factory.TaskStrategyFactory;
import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;

import java.util.concurrent.Callable;

public class BaseTaskCommand implements Callable<BaseRespDTO<Object>> {

    private String key;

    private TaskStrategyFactory taskStrategyFactory;

    public BaseTaskCommand(String key, TaskStrategyFactory taskStrategyFactory){
        this.key = key;
        this.taskStrategyFactory = taskStrategyFactory;
    }

    @Override
    public BaseRespDTO<Object> call() throws Exception {
        return taskStrategyFactory.executeTask(key);
    }
}
