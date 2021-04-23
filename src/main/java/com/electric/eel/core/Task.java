package com.electric.eel.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Lien6o
 * @date 2021/4/22 3:11 下午
 */
public class Task<T, R> {

    private final List<Task<?, ?>> dependOnTaskLit = new ArrayList<>();

    public List<Task<?, ?>> getDependOn() {
        return dependOnTaskLit;
    }

    public Task<T, R> dependOn(Task<?, ?>... task) {
        dependOnTaskLit.addAll(Arrays.asList(task));
        return this;
    }

    public Task<T, R> dependOnAll() {
        return this;
    }

    public R doTask(Function<T, R> task) {

        return null;
    }


}
