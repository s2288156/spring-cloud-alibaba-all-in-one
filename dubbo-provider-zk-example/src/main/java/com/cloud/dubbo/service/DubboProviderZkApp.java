package com.cloud.dubbo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@SpringBootApplication
public class DubboProviderZkApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderZkApp.class, args);
    }
}
