package com.lly.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lly
 * @Date: 2020/9/24
 * @Description:
 */
@RestController
public class TestAsync {
    @Autowired
    private AsyncSerice asyncSerice;
    @GetMapping("/hello")
    public String hello(){
        asyncSerice.hello();
        return "asdhjgfjhasgfhj";
    }
}
