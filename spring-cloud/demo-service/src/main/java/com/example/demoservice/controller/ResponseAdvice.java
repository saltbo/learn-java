package com.example.demoservice.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (Objects.requireNonNull(methodParameter.getMethod()).getName().equals("errorHandler")) {
            return body;
        }

        if (!serverHttpRequest.getURI().getPath().startsWith("/api")) {
            return body;
        }

        return Map.of("code", 0, "msg", "ok", "data", body);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(Exception ex) {
        return Map.of("code", -1, "msg", ex.getMessage(), "data", "");
    }
}