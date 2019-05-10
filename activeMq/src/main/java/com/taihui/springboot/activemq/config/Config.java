package com.taihui.springboot.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class Config {
    /**
     * 设置监听的目的地  "active.queue" ，供消费者获取消息。
     *
     * @return
     */
    @Bean
    public Queue queue() {
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("active.queue");
        return activeMQQueue;
    }

    @Bean
    public Topic topic() {
        ActiveMQTopic activeMQTopic = new ActiveMQTopic("active.topic");
        return activeMQTopic;
    }

    /**
     * Topic 订阅模式  DefaultJmsListenerContainerFactory
     * 需要配置这个实现pub/sub 发布订阅模式
     *
     * @param connectionFactory   连接工厂
     * @return  默认Jms容器工厂监听
     */
    @Bean(name = "topicJmsListenerContainerFactory")
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setPubSubDomain(true);//设置Topic 模式
        return containerFactory;
    }


}
