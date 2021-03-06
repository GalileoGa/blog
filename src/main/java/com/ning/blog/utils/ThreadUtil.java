package com.ning.blog.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程工具类，还不知道怎么写。所以就随便先写点东西，以后咋往这里面添加东西。
 */
public class ThreadUtil {

    //执行短期异步任务
    public static ExecutorService getCachedThreadPool() {
        return Executors.newCachedThreadPool();
    }

    //定长线程池
    public static ExecutorService getixedThreadPool(int lenght) {
        return Executors.newFixedThreadPool(lenght);
    }

    //定长周期任务线程池
    public static ExecutorService getScheduledThreadPool(int lenght) {
        return Executors.newScheduledThreadPool(lenght);
    }

    //工作者线程，保证序列化。
    public static ExecutorService getSingleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

}
