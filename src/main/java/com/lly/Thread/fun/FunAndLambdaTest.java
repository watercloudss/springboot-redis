package com.lly.Thread.fun;

import java.util.function.Function;

/**
 * @Author: lly
 * @Date: 2020/9/28
 * @Description:
 */
public class FunAndLambdaTest {
    public static void main(String[] args) {
//        Function<String,Integer> funtion = (str)->{return 1000;};
//        Function<String,Integer> funtion1 = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return 666;
//            }
//        };
        //       Function函数式接口                   lamdba表达式
        Function<String,Integer> funtion = str->{int a = 100+1; return a;};
        System.out.println(funtion.apply("asd"));
    }
}
