package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 1,加载druid.properties配置文件
 * 2，创建Druid连接对象
 * 3，提供获得连接池对象的方法
 * 4，提供从连接池对象Connection的方法
 */
public class DruidDBUtils {
    public static DataSource ds=null;
    static {
        try {
            //1.加载配置文件
            InputStream is=DruidDBUtils.class.getClassLoader().getResourceAsStream("Druid.properties");
            Properties properties=new Properties();
            properties.load(is);
            //2.创建Druid连接对象
            ds= DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //3,提供获得连接池对象的方法

    public static DataSource getDs() {
        return ds;
    }

    //4,提供从连接池中获取连接对象Connection的方法
    public static Connection getConnection() throws SQLException {
        Connection conn=ds.getConnection();
        return conn;
    }


}
