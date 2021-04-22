package com.electric.eel.core;

/**
 * @author Lien6o
 * @date 2021/4/22 3:11 下午
 */
public class Task<T> {

    public Task<T> dependOn(Task... task) {
        return this;
    }

    public T doTask(Task<T> task) {
        return null;
    }


}
