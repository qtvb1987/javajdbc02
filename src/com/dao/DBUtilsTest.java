package com.dao;

import com.utils.DruidDBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsTest {
    Connection conn =null;
    @Test
    public void transfer(){
        try {
            conn = DruidDBUtils.getConnection();
            conn.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            String sql1 = "update account set money=money-? where name=?";
            qr.update(conn,sql1,100,"nom");
            String sql2 = "update account set money=money+? where name=?";
            qr.update(conn,sql2,100,"bom");
            DbUtils.commitAndClose(conn);
        }
        catch (Exception e){
            e.printStackTrace();
            try {
                DbUtils.rollbackAndClose(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
