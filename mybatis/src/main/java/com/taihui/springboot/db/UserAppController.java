package com.taihui.springboot.db;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.taihui.springboot.db")
@EnableCaching //启动缓存
public class UserAppController {
    public static void main(String[] args){
        SpringApplication.run(UserAppController.class,args);
    }
}
