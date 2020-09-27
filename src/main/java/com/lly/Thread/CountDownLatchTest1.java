package com.lly.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: lly
 * @Date: 2020/9/27
 * @Description:
 */
public class CountDownLatchTest1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" go out");
                countDownLatch.countDown();//数量-1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零再往下执行
        System.out.println("close door");
    }
}
