package com.cloud.dubbo.service;

import com.cloud.dubbo.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@Slf4j
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
        log.info("this is dubbo consumer web");
        QueryUser queryUser = new QueryUser();
        queryUser.setId(id);
        return userService.getUser(queryUser);
    }
}
