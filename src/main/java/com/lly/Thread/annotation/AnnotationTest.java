package com.lly.Thread.annotation;

/**
 * @Author: lly
 * @Date: 2020/10/3
 * @Description:
 */
public class AnnotationTest {
    public static void main(String[] args) {
               AnnotationTest a=new AnnotationTest();
               a.test("da");
    }

    @MyAnno
    public void test(String name){
        System.out.println("测试注解！"+name);
    }
}
