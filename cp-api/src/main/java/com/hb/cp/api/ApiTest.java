package com.hb.cp.api;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest implements InitializingBean {

    @Value("${username}")
    private String username;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(username);
    }

}
