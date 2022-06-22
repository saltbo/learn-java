package com.example.demoservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("eureka")
public interface EurekaClient {

    @GetMapping("/actuator/health")
    String getHealth();

}
