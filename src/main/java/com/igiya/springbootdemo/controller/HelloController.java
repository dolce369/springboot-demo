package com.igiya.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String download(@RequestParam(name = "type") String type){
        if (null == type || type.isBlank()) {
            return "no type";
        }
        return type;
    }
}
