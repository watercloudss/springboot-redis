package com.lly.Thread;

/**
 * @Author: lly
 * @Date: 2020/9/25
 * @Description:
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
//        Ticket t=new Ticket();
//        new Thread(()->{
//            for(int i=0;i<60;i++) {
//                t.sale();
//            }
//            },"a").start();
//        new Thread(()->{
//            for(int i=0;i<60;i++) {
//            t.sale();
//            }
//            },"b").start();
//        new Thread(()->{
//            for(int i=0;i<60;i++) {
//                t.sale();
//            }
//            },"c").start();
//        Ticket1 t1 = new Ticket1();
//        new Thread(t1,"7").start();
        char a = 0;
        boolean b = false;
        float c = 0F;
        double d = 0D;
        byte h = 16;
        short e = 0;
        int f = 0;
        long g = 0L;

        System.out.println(h);
    }
}
class Ticket{
    public int num =50;
    public synchronized void sale(){
        if(num>0)
            System.out.println(Thread.currentThread().getName()+(num--)+"剩余"+num);
    }
}
class Ticket1 implements Runnable{
    public static int num =50;

    @Override
    public void run() {
        this.sale();
    }

    public void sale(){
        synchronized (this){
            if(num>0)
                System.out.println(Thread.currentThread().getName()+(num--)+"剩余"+num);
        }
    }
}