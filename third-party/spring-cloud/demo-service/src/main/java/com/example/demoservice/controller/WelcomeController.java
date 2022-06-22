package com.example.demoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.netflix.eureka.http.WebClientEurekaHttpClient;
import reactor.core.publisher.Mono;

import java.net.Inet4Address;

@RestController
@EnableFeignClients
public class WelcomeController {

    private WebClient.Builder webClientBuilder;
    private EurekaClient ec;

    public WelcomeController(EurekaClient ec, WebClient.Builder webClientBuilder) {
        this.ec = ec;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/welcome")
    public Object welcome() throws Exception {
        Mono<String> resp = webClientBuilder.build().get().uri("/actuator/health").retrieve().bodyToMono(String.class);
        System.out.println(resp.block());
        System.out.println(ec.getHealth());

        return String.format("welcome, %s", Inet4Address.getLocalHost().getHostName());
    }
}

