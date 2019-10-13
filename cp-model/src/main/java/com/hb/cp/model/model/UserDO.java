package com.hb.cp.model.model;

import java.io.Serializable;

public class UserDO implements Serializable {

    private static final long serialVersionUID = 3128289605451551040L;

    private String userName;

    private Integer userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
