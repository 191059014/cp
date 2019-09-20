package com.hb.cp.web.controller;

import com.hb.cp.api.core.IUserService;
import com.hb.cp.model.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/findById")
    public UserDO findById(String userId) {
        return userService.findById(userId);
    }

}
