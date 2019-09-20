package com.hb.cp.api.core.impl;

import com.hb.cp.api.core.IUserService;
import com.hb.cp.dao.mapper.UserMapper;
import com.hb.cp.model.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDO findById(String userId) {
        return userMapper.findById(userId);
    }
}
