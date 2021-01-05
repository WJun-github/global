package com.wj.jdbc.config;

import com.wj.jdbc.entity.ConnectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author wj
 * @version 1.0
 * @date 2021/1/5 0005
 * @description
 */
public class ConnectionUtil {

    public static Connection getConnection(ConnectionInfo info) throws Exception {
        Class.forName(info.getDriverClassName());
        Connection connection =
                DriverManager.getConnection(info.getUrl(), info.getUsername(), info.getPassword());
        return connection;
    }
}
