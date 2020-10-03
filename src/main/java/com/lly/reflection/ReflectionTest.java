package com.lly.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: lly
 * @Date: 2020/10/3
 * @Description:
 */
public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class c1=Class.forName("com.lly.reflection.User");
        Class c2=Class.forName("com.lly.reflection.User");
        Class c3=Class.forName("com.lly.reflection.User");

        //一个类在内存中只有一个Class对象
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.println(Class.forName("com.lly.reflection.User"));
        System.out.println(User.class);
        System.out.println(new User().getClass());

        //可见只有一个Class对象
        System.out.println(Class.forName("com.lly.reflection.User").hashCode());
        System.out.println(User.class.hashCode());
        System.out.println(new User().getClass().hashCode());

        //基本数据类型使用包装类的TYPE属性得到class类
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //通过反射动态创建对象
        User user = (User) c1.newInstance();
        System.out.println(user);
        //通过反射构造器动态创建对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, String.class);
        User user1 = (User) declaredConstructor.newInstance("小明",19,"男");
        System.out.println(user1);

        User user2 = (User) c2.newInstance();
        Method setName = c2.getDeclaredMethod("setName", String.class);
        setName.invoke(user2,"小红");
        System.out.println(user2);
    }
}
