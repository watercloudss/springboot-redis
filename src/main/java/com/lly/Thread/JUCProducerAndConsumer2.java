package com.lly.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class JUCProducerAndConsumer2 {
    public static void main(String[] args) {
        C c = new C();
      new Thread(()->{
          for(int i=0;i<30;i++){
              try {
                  c.one();
              }catch (Exception e){

              }
          }
      },"one").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    c.two();
                }catch (Exception e){

                }
            }
        },"two").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    c.two();
                }catch (Exception e){

                }
            }
        },"two").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    c.three();
                }catch (Exception e){

                }
            }
        },"three").start();
    }
}

class C{
    private int num=1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public  void one() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();//线程等待
            }
            System.out.println(Thread.currentThread().getName());
            num=2;
            condition2.signal();//通知线程
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public  void two() throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();//线程等待
            }
            System.out.println(Thread.currentThread().getName());
            num=3;
            condition3.signal();//通知线程
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void three() throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();//线程等待
            }
            System.out.println(Thread.currentThread().getName());
            num=1;
            condition1.signal();//通知线程
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}