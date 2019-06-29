package com.example.sysdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.sysdemo.mapper")
public class SysdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysdemoApplication.class, args);
    }

}
