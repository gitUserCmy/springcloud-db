package com.taihui.springboot.db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true) //启动Jpa事务管理
@EnableJpaRepositories(basePackages = {"com.taihui.mysql.repository.*"})
@EntityScan(basePackages = {"com.taihui.mysql.entity.*"})
public class JpaConfiguration {

    @Bean
    public PersistenceExceptionTranslationPostProcessor postProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
