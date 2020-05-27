package com.hb.cp.web.test;

import com.hb.mybatis.annotation.Column;
import com.hb.mybatis.annotation.Table;

/**
 * 用户表
 */
@Table("t_user")
public class User {

    // 用户名
    @Column("user_name")
    private String userName;

    // 密码
    @Column("password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

    