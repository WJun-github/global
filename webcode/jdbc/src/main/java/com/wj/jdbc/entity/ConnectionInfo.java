package com.wj.jdbc.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/4 0004
 * @description
 */
@Data
@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionInfo {

    private String driverClassName;

    private String url;

    private String username;

    private String password;
}
