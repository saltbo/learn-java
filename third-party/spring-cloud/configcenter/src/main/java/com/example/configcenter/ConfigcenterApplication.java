package com.example.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer //https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_quick_start
@SpringBootApplication
public class ConfigcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigcenterApplication.class, args);
    }

}
