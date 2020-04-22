package com.cloud.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author wcy
 */
@Service(version = "1.0.0")
public class UserServiceProvider implements UserService{
    @Override
    public User getUser(String id) {
        User user = new User();
        user.setId(id);
        user.setName("lao wang");
        user.setAge(11);
        return user;
    }
}
