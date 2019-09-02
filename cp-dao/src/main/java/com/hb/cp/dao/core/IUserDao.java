package com.hb.cp.dao.core;

import com.hb.cp.dao.base.IBaseRepository;
import com.hb.cp.model.entity.User;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.core.IUserDao.java, v1.0
 * @date 2019年09月02日 22时33分
 */
public interface IUserDao extends IBaseRepository<String, User> {

    User addUser(User user);

}
