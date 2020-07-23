package com.nickperov.stud.graalvm.spring.hello_world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApp {

    public static void main(String[] args) {
        System.out.println("Hello World!!!");
        SpringApplication.run(HelloWorldApp.class, args);
    }
}