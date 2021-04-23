package com.electric.eel.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Lien6o
 * @date 2021/4/22 3:05 下午
 */
public class Pipeline {

    private AtomicBoolean launcher = new AtomicBoolean(Boolean.FALSE);

    private final ExecutorService executorService;

    private final Long timeout;

    private final TimeUnit timeUnit;

    private List<List<Task<?, ?>>> nodeTaskList = new ArrayList<>();

    public Pipeline(Long timeout, TimeUnit timeUnit, ExecutorService executorService) {
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.executorService = executorService;
    }

    public Pipeline allThen(Task<?, ?>... tasks) {
        this.nodeTaskList.add(Arrays.asList(tasks));
        return this;
    }

    public Pipeline anyThen(Task<?, ?>... tasks) {
        this.nodeTaskList.add(Arrays.asList(tasks));
        return this;
    }

    public Pipeline chain(Pipeline... chains) {

        return this;
    }

    /**
     * run choreography
     * <p>
     * allOf => 所有的CompletableFuture都执行完后执行计算。
     * anyOf => 任意一个CompletableFuture执行完后就会执行计算
     */
    public void run() {
        if (!launcher.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            throw new IllegalArgumentException();
        }
        long remainTime = timeUnit.toNanos(timeout);
        for (List<Task<?, ?>> taskList : nodeTaskList) {

            for (Task<?, ?> task : taskList) {

            }
        }

    }


}
