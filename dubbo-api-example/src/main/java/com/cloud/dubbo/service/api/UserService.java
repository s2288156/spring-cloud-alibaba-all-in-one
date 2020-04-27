package com.cloud.dubbo.service.api;

import com.cloud.dubbo.service.QueryUser;
import com.cloud.dubbo.service.User;

/**
 * @author wcy
 */
public interface UserService {

    User getUser(QueryUser query);

}
