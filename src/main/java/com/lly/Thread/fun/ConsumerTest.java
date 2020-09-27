package com.lly.Thread.fun;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: lly
 * @Date: 2020/9/28
 * @Description:
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("asdas");

        Supplier<String> supplier = ()->{
            return "asdas";
        };
        System.out.println(supplier.get());
    }
}
