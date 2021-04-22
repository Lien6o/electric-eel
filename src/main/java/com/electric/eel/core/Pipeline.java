package com.electric.eel.core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Lien6o
 * @date 2021/4/22 3:05 下午
 */
public class Pipeline {

    private final ExecutorService executorService;

    private final Long timeout;

    private final TimeUnit timeUnit;

    private List<List<Task<?>>> nodeTaskList;

    public Pipeline(Long timeout, TimeUnit timeUnit, ExecutorService executorService) {
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.executorService = executorService;
    }

    public Pipeline node(Task<?>... node) {
        this.nodeTaskList.add(Arrays.asList(node));
        return this;
    }

    /**
     * run choreography
     */
    public void run() {
        long remainTime = timeUnit.toNanos(timeout);
        for (List<Task<?>> taskList : nodeTaskList) {

            for (Task<?> task : taskList) {
                Future<Object> submit = executorService.submit(new Callable<Object>() {
                    @Override
                    public Object call() throws Exception {
                        Task<?> task = taskList.get(0);
                        Object o = task.doTask(new Task<>());
                        return null;
                    }
                });
            }


        }
    }


}
