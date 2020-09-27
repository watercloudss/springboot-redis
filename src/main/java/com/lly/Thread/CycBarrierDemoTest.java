package com.lly.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: lly
 * @Date: 2020/9/27
 * @Description:
 */
public class CycBarrierDemoTest {
    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for(int i=1;i<8;i++){
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 收集了"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();//等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
