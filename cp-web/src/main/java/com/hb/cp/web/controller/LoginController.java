package com.hb.cp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("controller/login")
public class LoginController {

    @RequestMapping("/login")
    public String home() {
        return "login";
    }

}
