package com.hb.cp.dao.mapper;

import com.hb.cp.model.model.UserDO;

public interface UserMapper {

    UserDO findById(String userId);

}
