package com.cloud.dubbo.service;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class QueryUser extends AbstractBaseReq implements Serializable {

    private static final long serialVersionUID = 5254321424562151849L;

    private String id;

}
