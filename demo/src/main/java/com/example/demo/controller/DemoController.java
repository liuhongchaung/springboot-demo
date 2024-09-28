package com.example.demo.controller;

import com.example.demo.entity.result.ResultMessage;
import com.example.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController
public class DemoController {

    @RequestMapping("/home")
    public ResultMessage<String> home() {
        return ResultUtil.success("hello word!");
    }
}
