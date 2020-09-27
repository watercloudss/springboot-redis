package com.lly.Thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: lly
 * @Date: 2020/9/27
 * @Description:
 */
public class CallableTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        A a = new A();
        FutureTask<String> futureTask = new FutureTask<String>(a); //适配类
        new Thread(futureTask).start();
        String out = futureTask.get();  //get可能会产生阻塞，把它放最后一行
        System.out.println(out);
    }
}
class A implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable在运行");
        return "这是callable的返回";
    }
}