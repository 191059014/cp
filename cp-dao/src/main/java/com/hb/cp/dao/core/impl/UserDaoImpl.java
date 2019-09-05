package com.hb.cp.dao.core.impl;

import com.hb.cp.dao.base.IBaseRepository;
import com.hb.cp.dao.core.IUserDao;
import com.hb.cp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.core.impl.UserDaoImpl.java, v1.0
 * @date 2019年09月02日 22时34分
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private IBaseRepository baseRepository;

    @Override
    public User addUser(User user) {
        return baseRepository.saveOrUpdate(user);
    }

}
