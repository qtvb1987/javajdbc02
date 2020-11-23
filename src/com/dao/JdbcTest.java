package com.dao;

import com.utils.DruidDBUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {
    Connection connection = null;
    PreparedStatement preparedStatement =null;
    PreparedStatement preparedStatement1 =null;
    @Test
    public void transfer()  {
        try {

            connection=DruidDBUtils.getConnection();
            //开启事务---手动开启
            connection.setAutoCommit(false);
            String sql = "update account set money=money-100 where name='nom'";
            preparedStatement = connection.prepareStatement(sql);
            int msg = preparedStatement.executeUpdate();
            sql = "update account set money=money+100 where name='bom'";
            preparedStatement1 = connection.prepareStatement(sql);
            int msg2 = preparedStatement1.executeUpdate();
            //提交事务
            connection.commit();
            preparedStatement.close();
            preparedStatement1.close();
            connection.close();
        }
        catch (Exception e){
            //打印异常信息
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        finally {
            try {
                preparedStatement.close();
                preparedStatement1.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
