package com.taihui.springboot.activemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Topic 消息监听、消费者
 */
@RestController
public class CustomerTopic1 {

    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerTopic1.class);

    /**
     * 配置该注解，表明消息监听，
     * containerFactory 属性可以配置发送消息的模式。 点对点（默认）  发布/订阅模式（需要配置 setPubSubDomain(true)）
     *
     * @param msg
     */
    @JmsListener(destination = "active.topic", containerFactory = "topicJmsListenerContainerFactory")
    public void revice1(Object msg) {
        LOGGER.info("tipic:" + msg);
    }


}
