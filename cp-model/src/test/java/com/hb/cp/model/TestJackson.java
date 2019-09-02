package com.hb.cp.model;

import com.alibaba.fastjson.JSON;
import com.hb.cp.model.entity.User;

public class TestJackson {

    public static void main(String[] args) {

        User user = new User();
        user.setUserId("huangbiao");
        user.setCreateUserId("zhangsan");
        user.setUpdateUserId("zhanglisi");
        user.setUserName(null);
        user.setDefault();
        System.out.println(JSON.toJSONString(user));
        System.out.println(user.toString());

    }

}
