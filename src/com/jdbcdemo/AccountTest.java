package com.jdbcdemo;

import com.service.AccountService;

public class AccountTest {
    public static void main(String[] args) {
        String oUser="nom";
        String iUser="bom";
        double money=100;
        AccountService as=new AccountService();
        try {
            as.transfer(oUser, iUser, money);
            System.out.println("转账成功");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("转账失败");
        }
    }
}
