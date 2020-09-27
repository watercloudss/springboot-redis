package com.lly.Thread.lock;

import javax.xml.stream.XMLOutputFactory;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class LockOfQuestions1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.call();
        }).start();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.sendSms();
        }).start();
    }
}
class Phone{
//    synchronized锁的对象是方法的调用者

  public synchronized void sendSms(){
        System.out.println("发短信");
  }

  public synchronized void call(){
      try {
          TimeUnit.SECONDS.sleep(1);
      } catch (Exception e) {
          e.printStackTrace();
      }
    System.out.println("打电话");
  }

}