package com.cloud.dubbo.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RestController
@SpringBootApplication
public class DubboConsumerZkApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerZkApp.class, args);
    }

    @Reference(version = "1.0.0", check = false)
    private UserService userService;

    @GetMapping("/consumer/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
}
