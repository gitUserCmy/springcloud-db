package com.taihui.springboot.activemq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者控制器
 * （客户端控制器 ）
 * 注意： 消费者、生产者都需要是bean，需要被Spring容器管理
 */
@RestController
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    /**
     * 监听JMS消息的注解，该注解的属性destination 用于指定要监听的目的地。
     *
     * @param msg
     */
    @JmsListener(destination = "active.queue")
    public void readActiveMq(Object msg) {
        LOGGER.info("接收到：" + msg.toString());
    }


}
