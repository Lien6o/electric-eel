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

        Task task1 = new Task<>();
        Task task2 = new Task<>();
        Task task3 = new Task<>();
        Task task4 = new Task<>();
        Task task5 = new Task<>();
        Task task6 = new Task<>();
        Task task7 = new Task<>();
        Task task8 = new Task<>();
        Task task9 = new Task<>();

        /*       ->  3
         * 1  ->          ->  7
         *       ->  4
         *                      ->  9
         *       ->  5
         * 2  ->          ->  8
         *       ->  6
         */


        pipeline.chain(

                pipeline.allThen(task1).allThen(task3.dependOn(task1), task4).anyThen(task7),

                pipeline.allThen(task2).allThen(task5, task6).allThen(task8)
        )
                .allThen(task9.dependOnAll())
                .run();

        /**
         *
         * pipeline.call(task1,task2).andThen()
         *
         * pipeline.call(chain(task1)
         *
         *
         *
         */

    }
}
