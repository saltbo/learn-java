package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public Object welcome() throws Exception {
        return String.format("welcome, %s", Inet4Address.getLocalHost().getHostName());
    }
}


