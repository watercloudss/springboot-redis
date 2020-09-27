package com.lly.Thread.unsafeList;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: lly
 * @Date: 2020/9/26
 * @Description:
 */
public class UnsafeList1 {
    public static void main(String[] args) {
//        List<String> strings1 = new ArrayList<>();
//        List<String> strings = Collections.synchronizedList(new ArrayList<>());
        List<String> strings  = new CopyOnWriteArrayList<>();

        for(int i=0;i<10;i++){
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0,5));
//                strings1.add(UUID.randomUUID().toString().substring(0,5));
//                System.out.println(strings1);
                System.out.println(strings);
            }).start();
        }

    }
}
