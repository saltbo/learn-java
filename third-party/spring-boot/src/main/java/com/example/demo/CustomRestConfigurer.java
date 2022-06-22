package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class CustomRestConfigurer implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
//        config.useHalAsDefaultJsonMediaType(false);
    }

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {

    }
}