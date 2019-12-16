package com.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Data
@Component
@ConfigurationProperties(prefix = "beijing")
public class BeiJingProp {

    private Integer code;

    private String name;
}
