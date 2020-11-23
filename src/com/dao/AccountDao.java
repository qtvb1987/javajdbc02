package com.dao;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDao {
    QueryRunner qr = new QueryRunner();
    public void out(Connection conn, String oUser, double money) throws SQLException {
        String sql1 = "update account set money=money-? where name=?";

        Object[] arr={money,oUser};
        qr.update(conn,sql1,arr);

    }

    public void in(Connection conn, String iUser, double money) throws SQLException {
        String sql2 = "update account set money=money+? where name=?";

        Object[] arr={money,iUser};
        qr.update(conn,sql2,arr);

    }
}
