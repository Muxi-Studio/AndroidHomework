package com.muxistudio.jinyixin.query.netWork;

import android.support.v4.util.Pools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jinyixin on 15/3/14.
 */
public class ThreadManager {
    private static ThreadManager threadManager;
    private ExecutorService pool = Executors.newSingleThreadExecutor();



}
