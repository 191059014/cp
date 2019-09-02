package com.hb.cp.model.entity;

import com.hb.cp.model.base.AbstractConnectEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.model.entity.User.java, v1.0
 * @date 2019年09月02日 09时40分
 */
@Entity
@Table(name = "t_user")
public class User extends AbstractConnectEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;

    @Column
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                "} " + super.toString();
    }
}
