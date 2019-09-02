package com.hb.cp.dao.core.impl;

import com.hb.cp.dao.base.BaseRepositoryImpl;
import com.hb.cp.dao.core.IUserDao;
import com.hb.cp.model.entity.User;
import org.springframework.stereotype.Repository;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.core.impl.UserDaoImpl.java, v1.0
 * @date 2019年09月02日 22时34分
 */
@Repository
public class UserDaoImpl extends BaseRepositoryImpl<String, User> implements IUserDao {

    @Override
    public User addUser(User user) {
        return save(user);
    }

}
