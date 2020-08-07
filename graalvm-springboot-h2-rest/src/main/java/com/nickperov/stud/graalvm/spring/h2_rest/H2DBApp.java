package com.nickperov.stud.graalvm.spring.h2_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(proxyBeanMethods = false, exclude = SpringDataWebAutoConfiguration.class)
public class H2DBApp {

    public static void main(String[] args) {
        SpringApplication.run(H2DBApp.class, args);
    }
}
