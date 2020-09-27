package com.lly.Thread;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        A a = new A();
      new Thread(()->{
          for(int i=0;i<30;i++){
              try {
                  a.consumer();
              }catch (Exception e){

              }
          }
      },"A").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    a.producer();
                }catch (Exception e){

                }
            }
        },"B").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    a.producer();
                }catch (Exception e){

                }
            }
        },"C").start();

        new Thread(()->{
            for(int i=0;i<30;i++){
                try {
                    a.consumer();
                }catch (Exception e){

                }
            }
        },"D").start();
    }
}
class A{
    private int num=0;

    public synchronized void producer() throws InterruptedException {
        while (num!=0){
//        if(num!=0){
            this.wait();//线程等待
            System.out.println(Thread.currentThread().getName()+" "+num);
        }
        num++;
        notifyAll();//通知线程
    }

    public synchronized void consumer() throws InterruptedException {
        while (num==0){
//        if(num==0){
            this.wait();  //线程等待
            System.out.println(Thread.currentThread().getName()+" "+num);
        }
        num--;
        notifyAll(); //通知线程
    }
}