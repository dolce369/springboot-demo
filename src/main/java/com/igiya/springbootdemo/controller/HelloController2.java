package com.igiya.springbootdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController2 {
    
    @GetMapping("/hello2")
    public String hello2() {
        return "hello2***";
    }
}
