package com.jdbcdemo;

import com.models.Emp;
import com.utils.DruidDBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DruidDBTest01 {

    @Test
    public void selectMethod01() throws SQLException {
        //获取QueryRunner对象
        QueryRunner queryRunner=new QueryRunner(DruidDBUtils.getDs());
        //指定sql
        String sql="select * from emp";
        List<Emp> emplist = queryRunner.query(sql, new BeanListHandler<Emp>(Emp.class));
        for (Emp emp : emplist) {
            System.out.println(emp);
        }
    }

    @Test
    public void insertMethod01() throws SQLException {
        //获取QueryRunner对象
        QueryRunner queryRunner=new QueryRunner(DruidDBUtils.getDs());
        //指定sql
        String sql="insert into  emp(ename,job,hiredate,sal)values(?,?,?,?)";
        Object[] arrs={"马云","董事","1999-9-9",9999};
        int msg = queryRunner.update(sql, arrs);
        System.out.println("返回结果:"+msg);

    }
    @Test
    public void updateMethod01() throws SQLException {
        //获取QueryRunner对象
        QueryRunner queryRunner=new QueryRunner(DruidDBUtils.getDs());
        //指定sql
        String sql="update emp set ename=? where empno=?";
        Object[] arrs={"张勇",303};
        int msg = queryRunner.update(sql, arrs);
        System.out.println("返回结果:"+msg);

    }
    @Test
    public void removeMethod01() throws SQLException {
        //获取QueryRunner对象
        QueryRunner queryRunner=new QueryRunner(DruidDBUtils.getDs());
        //指定sql
        String sql="delete from  emp  where empno=?";
        int msg = queryRunner.update(sql, 303);
        System.out.println("返回结果:"+msg);

    }
}
