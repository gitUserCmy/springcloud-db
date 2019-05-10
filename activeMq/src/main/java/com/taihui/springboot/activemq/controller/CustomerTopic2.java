package com.taihui.springboot.activemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Topic 消息监听、接收者
 */
@RestController
public class CustomerTopic2 {


    public static final Logger LOGGER = LoggerFactory.getLogger(CustomerTopic2.class);

    @JmsListener(destination = "active.topic", containerFactory = "topicJmsListenerContainerFactory")
    public void revice2(Object msg) {
        LOGGER.info("tipic:" + msg);
    }
}
