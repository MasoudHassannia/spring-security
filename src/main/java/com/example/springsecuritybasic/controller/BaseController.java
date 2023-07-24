package com.example.springsecuritybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/welcome")
    public String welCome(){
        return "Welcome to SpringBoot Security ";
    }
}
