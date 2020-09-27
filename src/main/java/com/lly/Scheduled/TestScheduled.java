package com.lly.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author: lly
 * @Date: 2020/9/25
 * @Description:
 */
@Service
public class TestScheduled {

               //分别代表秒 分 时 日 月 周几  代表每天的0点12分30 执行一次
    @Scheduled(cron="30 12 0 * * ?")
    public void hello(){
        System.out.println("任务执行了。。。。");
    }
}
