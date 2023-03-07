package com.igiya.springbootdemo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController2 {
    
    @GetMapping("/hello2")
    public ResponseEntity<String> hello2() {

        return ResponseEntity.ok("hello2*** hello just for testing purpose");
    }
}
