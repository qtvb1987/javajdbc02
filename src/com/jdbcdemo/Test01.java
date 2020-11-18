package com.jdbcdemo;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.sql.*;

public class Test01 {
    /**
     * 删除
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void jdbctestdemo04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql="delete from  emp   where empno=301";
        Statement statement = connection.createStatement();
        int result= statement.executeUpdate(sql);
        System.out.println("执行："+result);
        statement.close();
        connection.close();
    }

    /**
     * 改
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void jdbctestdemo03() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql="update emp set ename='老黄' where empno=300";
        Statement statement = connection.createStatement();
        int result= statement.executeUpdate(sql);
        System.out.println("执行："+result);
        statement.close();
        connection.close();
    }

    /**
     * 增
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void jdbctestdemo02() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql="insert into  emp(ename,job,hiredate,sal)values('老刘','总经理',Now(),889)";
        Statement statement = connection.createStatement();
        int result= statement.executeUpdate(sql);
        System.out.println("执行行："+result);
        statement.close();
        connection.close();
    }

    /**
     * 查
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void jdbctestdemo01() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/sqltestdb?serverTimezone=UTC";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql="select * from emp";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String empno = resultSet.getString("empno");
            String ename = resultSet.getString("ename");
            System.out.println("返回行值："+empno+"--"+ename);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
