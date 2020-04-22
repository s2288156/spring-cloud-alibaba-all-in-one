package com.cloud.dubbo.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 9165191186357693888L;

    private String id;

    private String name;

    private Integer age;
}
