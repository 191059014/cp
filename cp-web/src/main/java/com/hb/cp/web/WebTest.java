package com.hb.cp.web;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebTest implements InitializingBean {

    @Value("${fullname}")
    private String fullname;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(fullname);
    }

}
