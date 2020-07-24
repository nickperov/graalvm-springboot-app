package com.nickperov.stud.graalvm.spring.hello_world;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return String.format("Hello from GraalVM %s", new Date());
    }
}
