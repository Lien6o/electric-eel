package com.electric.eel.core;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Lien6o
 * @date 2021/4/22 3:05 下午
 */
public class Test {
    public static void main(String[] args) {

        Pipeline pipeline = new Pipeline(100L, TimeUnit.DAYS, Executors.newSingleThreadExecutor());

        Task<String> task1 = new Task<>();
        Task<Long> task2 = new Task<>();
        Task<Long> task3 = new Task<>();
        Task<Long> task4 = new Task<>();
//        pipeline.node(task1, task2)
//                .node(task3.dependOn(task1), task4.dependOn(task1, task2))
//                .run();

        pipeline.run();

    }
}
