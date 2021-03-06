package com.cloud.dubbo.service;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractBaseReq implements Serializable {

    private static final long serialVersionUID = 9165191186357693888L;

    private String id;

    private String name;

    private Integer age;
}
