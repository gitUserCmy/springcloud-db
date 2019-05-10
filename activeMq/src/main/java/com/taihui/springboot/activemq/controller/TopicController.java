package com.taihui.springboot.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;

/**
 * Topic模式  生成者
 */
@RestController
public class TopicController {

    @Autowired
    private Topic topic;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendTopic")
    public void sendTipic() {
        jmsMessagingTemplate.convertAndSend(this.topic, "send topic msg");
    }


}
