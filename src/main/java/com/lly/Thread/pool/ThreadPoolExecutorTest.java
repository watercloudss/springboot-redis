package com.lly.Thread.pool;

import java.util.concurrent.*;

/**
 * @Author: lly
 * @Date: 2020/9/28
 * @Description:
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//获取cpu核数
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,//默认线程池保持2个线程
                8,//线程池最多5个线程
                10,//线程池达到5个线程后，一段时间（10秒）后还是2个线程在使用，那就保持线程池默认2个线程
                TimeUnit.SECONDS,//上一个参数的单位
                new LinkedBlockingDeque<>(3),//阻塞队列，线程池达到默认时，满足不了还需要更多线程，那么这些就在这个阻塞队列里等着
                Executors.defaultThreadFactory(),//线程工程，一般不做改变
                 new ThreadPoolExecutor.AbortPolicy()//阻塞策略，线程池最大值满了，阻塞队列也满了，那就抛出异常或不处理...等,AbortPolicy就会抛异常
//                 new ThreadPoolExecutor.CallerRunsPolicy()//阻塞策略，哪来的回哪去
//                 new ThreadPoolExecutor.DiscardPolicy()//阻塞策略,不抛出异常，丢掉任务，9个线程只执行8个，有一个丢掉不执行
//                new ThreadPoolExecutor.DiscardOldestPolicy()//阻塞策略,不抛出异常，尝试和最早的竞争，竞争成功就执行否则丢掉
        );
//        i分别设为3、4、5、6、7、8、9    8个线程时最大和阻塞满了，该线程池饱满了，在来一个线程，9个时就会按阻塞策略处理,抛出一个异常
        try {
            for(int i=0;i<15;i++){
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
