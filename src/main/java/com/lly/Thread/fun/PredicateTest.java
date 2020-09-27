package com.lly.Thread.fun;

import java.util.function.Predicate;

/**
 * @Author: lly
 * @Date: 2020/9/28
 * @Description:
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (a)->{
            if(a==0)
                return true;
            else
                return false;
        };
        System.out.println(predicate.test(1));
    }

}
