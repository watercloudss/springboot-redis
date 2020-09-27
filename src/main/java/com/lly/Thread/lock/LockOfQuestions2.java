package com.lly.Thread.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class LockOfQuestions2 {
    public static void main(String[] args) {
        Phone1 phone = new Phone1();

        new Thread(()->{
            phone.call();
        }).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.sendSms();
        }).start();
    }
}

class Phone1{
//    synchronized锁的对象是方法的调用者

  public void sendSms(){
        System.out.println("发短信");
  }

  public synchronized void call(){
      try {
          TimeUnit.SECONDS.sleep(3);
      } catch (Exception e) {
          e.printStackTrace();
      }
    System.out.println("打电话");
  }

}