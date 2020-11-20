package com.wj.nettyclient.threadpool;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * @author wj
 * @version 1.0
 * @date 2020/11/18 0018
 * @description
 */
public class FixTreadPool implements ThreadPoolFactory {
    @Override
    public ExecutorService init() {

        return new ThreadPoolExecutor(5,
                5, 30L,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue<Runnable>(1024),
                new DefaultThreadFactory("MyThreadFactory",true),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
