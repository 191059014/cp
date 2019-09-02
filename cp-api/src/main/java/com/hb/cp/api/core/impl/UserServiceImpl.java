package com.hb.cp.api.core.impl;

import com.hb.cp.api.core.IUserService;
import com.hb.cp.dao.core.IUserDao;
import com.hb.cp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.api.core.impl.UserServiceImpl.java, v1.0
 * @date 2019年09月02日 22时32分
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

}
