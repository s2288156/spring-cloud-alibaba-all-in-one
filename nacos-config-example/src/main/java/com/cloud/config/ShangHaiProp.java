package com.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Data
@Component
@ConfigurationProperties(prefix = "shanghai")
public class ShangHaiProp {

    private Integer code;

    private String name;
}
