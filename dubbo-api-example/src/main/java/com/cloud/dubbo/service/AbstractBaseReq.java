package com.cloud.dubbo.service;

import lombok.Data;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class AbstractBaseReq implements Serializable {
    private static final long serialVersionUID = -4990624458217979305L;
    private String threadId;

    public AbstractBaseReq() {
        this.threadId = StringUtils.isEmpty(threadId) ? MDC.get("threadId") : threadId;
        MDC.put("threadId", threadId);
    }
}
