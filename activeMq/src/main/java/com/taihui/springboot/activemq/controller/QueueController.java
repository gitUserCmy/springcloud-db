package com.taihui.springboot.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 队列消息控制器
 */
@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 点对点发送消息
     */
    @Autowired
    private Queue queue;

    /**
     * 指定了消息发送的目的地为Queue 对象，所发送的内容为 ‘’
     */
    @RequestMapping("/send")
    public void send() {
        System.out.println("send ");
        jmsMessagingTemplate.convertAndSend(this.queue, "新发送的消息");
    }

}
