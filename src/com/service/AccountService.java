package com.service;

import com.dao.AccountDao;
import com.utils.DruidDBUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 业务类
 */
public class AccountService {
    Connection conn =null;
    public void transfer(String oUser,String iUser,double money){
        try {
            conn = DruidDBUtils.getConnection();
            conn.setAutoCommit(false);

            AccountDao accountDao=new AccountDao();
            accountDao.out(conn,oUser,money);
            accountDao.in(conn,iUser,money);
            DbUtils.commitAndCloseQuietly(conn);
        }
        catch (Exception e){
            System.out.println("事务回滚操作");
            DbUtils.rollbackAndCloseQuietly(conn);
            throw new RuntimeException(e);
        }
    }
}
