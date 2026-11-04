package com.example.demo;

import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello() {
        log.info("Endpoint /hello berhasil dipanggil "+new Date());
        return "Hello World";
    }

    @GetMapping("/hello-json")
    public Map<String, String> sayHelloJson() {
        log.info("Endpoint /hello-json dipanggil");
        return Map.of("message", "Hello World");
    }
}