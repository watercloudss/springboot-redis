package com.lly.Thread.stream;

import com.lly.redis.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: lly
 * @Date: 2020/9/28
 * @Description:
 */
public class StreamTest {
//    1、id必须是偶数
//    2、年龄必须大于23
//    3、用户名转为大写
//    4、用户名倒着排序
//    5、只输出一个用户
    public static void main(String[] args) {
        User user1 = new User(1,"asd",25);
        User user2 = new User(2,"wqe",29);
        User user3 = new User(3,"fgdh",17);
        User user4 = new User(4,"qw",21);
        User user5 = new User(5,"fg",22);
        User user6 = new User(6,"gfh",18);
        User user7 = new User(7,"ert",26);
        User user8 = new User(8,"ty",24);
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8);
        users.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{u.getName().toUpperCase();return u;})
                .sorted((u1,u2)->{return u2.getName().compareTo(u1.getName());})
                .limit(1)
                .forEach(System.out::println);
    }
}
