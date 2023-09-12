package com.example.multiServerLearn.business.common;

import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Component
public class ParallelMethod {
    /**
     *
     * @param taskList 提交的任务列表
     * @param timeOut 超时时间
     * @param executor 线程池
     * @return
     */
    public List<BaseRespDTO<Object>> executeTask(List<Callable<BaseRespDTO<Object>>> taskList, long timeOut, ExecutorService executor) {
        List<BaseRespDTO<Object>> resultList = new ArrayList<>();
        //校验参数
        if(taskList == null || taskList.size() == 0){
            return resultList;
        }

        if(executor == null){
            return resultList;
        }

        if(timeOut <= 0){
            return resultList;
        }
        //构建ExecutorCompletionsService 和 线程池关联
        CompletionService<BaseRespDTO<Object>> baseRespDTO = new ExecutorCompletionService<BaseRespDTO<Object>>(executor);
        //提交任务
        for(Callable<BaseRespDTO<Object>> task : taskList){
            baseRespDTO.submit(task);
        }

        //执行任务并阻塞获取执行结果
        try {
            for (int i = 0; i < taskList.size(); i++) {
                Future<BaseRespDTO<Object>> future = baseRespDTO.poll(timeOut, TimeUnit.SECONDS);
                resultList.add(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        return resultList;
    }
}
