package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@ComponentScan("com.example.demo")
@EnableSwagger2
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }
}
