package com.jeff.core.controller;

import com.jeff.common.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ExampleController")
public class ExampleController {
    @GetMapping("findAll")
    public Result findAll(){
        return Result.successJson("成功");
    }
}
