package com.example.multiServerLearn.business.Parallel.factory;

import com.example.multiServerLearn.business.Parallel.strategy.IBaseTask;
import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//策略工厂类
@Component
public class TaskStrategyFactory implements ApplicationContextAware {

    //将实现放到map 中，然后根据请求类型调用不同的策略类
    private Map<String , IBaseTask> map = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, IBaseTask> tempMap = applicationContext.getBeansOfType(IBaseTask.class);
        tempMap.values().forEach(iBaseTask -> {
            map.put(iBaseTask.getTaskType(), iBaseTask);
        });
    }

    public BaseRespDTO<Object> executeTask(String key){
        IBaseTask baseTask = map.get(key);
        if(baseTask != null){
            System.out.println("工厂策略实现类执行");
            return baseTask.execute();
        }
        return null;
    }
}
