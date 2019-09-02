package com.hb.cp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:META-INF/applicationContext-web.xml"})
@EntityScan(basePackages = "com.hb.cp.model.entity")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}