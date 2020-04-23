package com.cloud.dubbo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author wcy
 */
@Slf4j
@Service(version = "1.0.0")
public class UserServiceProvider implements UserService{
    @Override
    public User getUser(String id) {
        log.info("here is dubbo service provider impl");
        User user = new User();
        user.setId(id);
        user.setName("lao wang");
        user.setAge(11);
        return user;
    }
}
