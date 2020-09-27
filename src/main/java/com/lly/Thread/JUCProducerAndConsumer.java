package com.lly.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class JUCProducerAndConsumer {
    public static void main(String[] args) {
        B b = new B();
      new Thread(()->{
          for(int i=0;i<30;i++){
              try {
                  b.consumer();
              }catch (Exception e){

              }
          }
      },"A").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    b.producer();
                }catch (Exception e){

                }
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    b.producer();
                }catch (Exception e){

                }
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    b.consumer();
                }catch (Exception e){

                }
            }
        },"D").start();
    }
}

class B{
    private int num=0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public  void producer() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();//线程等待
                System.out.println(Thread.currentThread().getName() + " " + num);
            }
            num++;
            condition.signalAll();//通知线程
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public  void consumer() throws InterruptedException {
        lock.lock();
        try {
            while (num == 0) {
                condition.await();  //线程等待
                System.out.println(Thread.currentThread().getName() + " " + num);
            }
            num--;
            condition.signalAll();//通知线程
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}