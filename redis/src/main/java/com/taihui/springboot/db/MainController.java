package com.taihui.springboot.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.taihui.springboot.db"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class}) //排除数据源自动配置，因为Redis 没有数据库连接。
public class MainController {
    public static void main(String[] args){
        SpringApplication.run(MainController.class,args);
    }
}
