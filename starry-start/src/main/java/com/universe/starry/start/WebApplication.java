package com.universe.starry.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.universe.starry")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.universe.starry.start.WebApplication.class, args);
    }

}
