package com.lly.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: lly
 * @Date: 2020/9/24
 * @Description:
 */
@Service
public class AsyncSerice {
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("业务正在处理。。。。");
    }

}
