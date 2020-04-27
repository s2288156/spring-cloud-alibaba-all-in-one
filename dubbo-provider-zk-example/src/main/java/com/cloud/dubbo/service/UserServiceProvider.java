package com.cloud.dubbo.service;

import com.cloud.dubbo.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.MDC;

/**
 * @author wcy
 */
@Slf4j
@Service(version = "1.0.0")
public class UserServiceProvider implements UserService {
    @Override
    public User getUser(QueryUser queryUser) {
        log.info("here is dubbo service provider impl");
        log.info("provider queryUser = {}", queryUser);
        User user = new User();
        user.setId(queryUser.getId());
        user.setName("lao wang");
        user.setAge(11);
        return user;
    }
}
