package com.hb.cp.api.core.impl;

import com.hb.cp.api.core.IUserService;
import com.hb.cp.model.model.UserDO;
import com.hb.mybatis.base.DmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private DmlMapper dmlMapper;

    @Override
    public UserDO findById(String userId) {
        Map<String, Object> conditions = new HashMap<>();
//        conditions.put("userId", "1");
//        conditions.put("userName", "huangbiao");
//        UserDO userDO = new UserDO();
//        userDO.setUserName("lisi");
        System.out.println(dmlMapper.selectPages("t_user",UserDO.class, conditions,"userId desc",0,1));
        return null;
    }
}
