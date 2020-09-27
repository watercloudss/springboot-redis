package com.lly.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lly
 * @Date: 2020/9/25
 * @Description:
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {
        Ticket2 t=new Ticket2();
        new Thread(()->{
            for(int i=0;i<20;i++) {
                t.sale();
            }
            },"a").start();
        new Thread(()->{
            for(int i=0;i<20;i++) {
            t.sale();
            }
            },"b").start();
        new Thread(()->{
            for(int i=0;i<20;i++) {
                t.sale();
            }
            },"c").start();
    }
}

class Ticket2{
    public int num =50;
    //创建一个锁
    Lock lock = new ReentrantLock();

    public void sale(){
//        加锁
        lock.lock();
        try {
            if(num>0)
                System.out.println(Thread.currentThread().getName()+(num--)+"剩余"+num);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            解锁
            lock.unlock();
        }
    }
}
