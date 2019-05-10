package com.taihui.springboot.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.taihui.springboot.db"})
public class MySql {
    public static void main(String[] args){
        SpringApplication.run(MySql.class,args);

    }
}
