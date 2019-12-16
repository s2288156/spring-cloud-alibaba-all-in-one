package com.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
@RefreshScope
@RestController
@SpringBootApplication
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class, args);
    }

    @Value("${refresh}")
    private String refresh;

    @Autowired
    private BeiJingProp beiJingProp;

    @Autowired
    private ShangHaiProp shangHaiProp;

    @GetMapping("/refresh")
    public String refresh() {
        return refresh;
    }

    @GetMapping("/beijing")
    public BeiJingProp beijing() {
        return beiJingProp;
    }

    @GetMapping("/shanghai")
    public ShangHaiProp shanghai() {
        return shangHaiProp;
    }
}
