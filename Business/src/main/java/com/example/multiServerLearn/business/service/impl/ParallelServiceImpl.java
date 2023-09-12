package com.example.multiServerLearn.business.service.impl;

import com.example.multiServerLearn.business.Parallel.BaseTaskCommand;
import com.example.multiServerLearn.business.Parallel.factory.TaskStrategyFactory;
import com.example.multiServerLearn.business.common.ParallelMethod;
import com.example.multiServerLearn.business.domin.cto.BaseRespDTO;
import com.example.multiServerLearn.business.service.ParallelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class ParallelServiceImpl implements ParallelService {

    @Autowired
    private ParallelMethod parallelMethod;

    @Autowired
    private TaskStrategyFactory taskStrategyFactory;


    @Override
    public Boolean testNeedTime() {
        //创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //管理任务
        CompletionService<BaseRespDTO<Object>> baseRespDTOCompletionService = new ExecutorCompletionService<>(executor);
        //创建任务
        Callable<BaseRespDTO<Object>> m1 = () -> {
            BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
            Integer integer = method1();
            respDTO.setKey("method1");
            respDTO.setData(integer);
            return respDTO;
        };

        Callable<BaseRespDTO<Object>> m2 = () -> {
            BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
            Integer integer = method2();
            respDTO.setKey("method2");
            respDTO.setData(integer);
            return respDTO;
        };

        Callable<BaseRespDTO<Object>> m3 = () -> {
            BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
            Integer integer = method3();
            respDTO.setKey("method3");
            respDTO.setData(integer);
            return respDTO;
        };

        Callable<BaseRespDTO<Object>> m4 = () -> {
            BaseRespDTO<Object> respDTO = new BaseRespDTO<Object>();
            Integer integer = method4();
            respDTO.setKey("method4");
            respDTO.setData(integer);
            return respDTO;
        };

        //提交任务
        baseRespDTOCompletionService.submit(m1);
        baseRespDTOCompletionService.submit(m2);
        baseRespDTOCompletionService.submit(m3);
        baseRespDTOCompletionService.submit(m4);


        //获取结果
        try {
            for (int i = 0; i < 4; i++) {
                Future<BaseRespDTO<Object>> baseRespDTOFuture = baseRespDTOCompletionService.take();
                BaseRespDTO<Object> baseRespDTO = baseRespDTOFuture.get();
                if ("method1".equals(baseRespDTO.getKey())) {
                    System.out.println("method1 success!");
                } else if ("method2".equals(baseRespDTO.getKey())) {
                    System.out.println("method2 success!");
                } else if ("method3".equals(baseRespDTO.getKey())) {
                    System.out.println("method3 success!");
                } else if ("method4".equals(baseRespDTO.getKey())) {
                    System.out.println("method4 success!");
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean testParallelMethod() {
        long beginTime = System.currentTimeMillis();
        System.out.println("开始并行查询" + beginTime);
        List<Callable<BaseRespDTO<Object>>> taskList = new ArrayList<>();
        taskList.add(new BaseTaskCommand("method1", taskStrategyFactory));
        taskList.add(new BaseTaskCommand("method2", taskStrategyFactory));
        taskList.add(new BaseTaskCommand("method3", taskStrategyFactory));
        taskList.add(new BaseTaskCommand("method4", taskStrategyFactory));
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<BaseRespDTO<Object>> resultList = parallelMethod.executeTask(taskList, 10, executor);
        if(resultList == null || resultList.size() == 0) return false;

        for(BaseRespDTO<Object> baseRespDTO : resultList)
        {
            if ("method1".equals(baseRespDTO.getKey())) {
                System.out.println("method1 success!");
            } else if ("method2".equals(baseRespDTO.getKey())) {
                System.out.println("method2 success!");
            } else if ("method3".equals(baseRespDTO.getKey())) {
                System.out.println("method3 success!");
            } else if ("method4".equals(baseRespDTO.getKey())) {
                System.out.println("method4 success!");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("结束并行查询" + endTime);
        System.out.println("总耗时：" + (endTime - beginTime));

        return true;
    }

    private Integer method1() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    private Integer method2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 2;
    }

    private Integer method3() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 3;
    }

    private Integer method4() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 4;
    }
}
