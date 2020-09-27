package com.lly.Thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author: lly
 * @Date: 2020/9/27
 * @Description:
 */
public class ExecutorsTest {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//创建单个线程的池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//创建固定个数线程的池
        ExecutorService threadPool = Executors.newCachedThreadPool();//可动态变化的池
        try {
            for(int i=0;i<10;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
