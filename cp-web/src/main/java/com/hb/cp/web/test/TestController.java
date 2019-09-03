package com.hb.cp.web.test;

import com.hb.cp.api.core.IUserService;
import com.hb.cp.dao.base.IBaseRepository;
import com.hb.cp.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * ========== Description ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.web.test.TestController.java, v1.0
 * @date 2019年09月02日 21时29分
 */
@RestController
public class TestController {

    @Autowired
    private IBaseRepository baseRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/test")
    public String test() {
        User user = new User();
        user.setUserId("34e71923-311c-40d8-a00d-a0567d0c301d");
        user.setUserName("huangbiao1");
        user.setDefault();
        Object save = userService.addUser(user);
        System.out.println(save);
        return save.toString();
    }

}
