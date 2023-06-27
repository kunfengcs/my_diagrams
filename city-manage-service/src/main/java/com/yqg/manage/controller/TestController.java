package com.yqg.manage.controller;

/**
 * @author suzhuang
 * @ClassName: TestController
 * @Function: TODO
 * @Date: 2023/6/26 16:00
 */

import com.yqg.manage.entity.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {


    @RequestMapping("/test")
    public String test(){
        return "hello,world";
    }

}

