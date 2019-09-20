package com.hb.cp.api.core;

import com.hb.cp.model.model.UserDO;

public interface IUserService {

    UserDO findById(String userId);

}
