package com.universe.starry.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@MapperScan(value = {"com.universe.starry.*.mapper"})
@SpringBootApplication(scanBasePackages = "com.universe.starry")
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.universe.starry.start.WebApplication.class, args);
    }

}
