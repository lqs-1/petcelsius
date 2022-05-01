package com.petcelsius.api.config;

import com.petcelsius.api.constant.Constant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 单体架构和mq有关系吗，是的没有关系
 */
@Configuration
public class RabbitMQConfig {


    // 创建交换机
    @Bean(Constant.SENDSMSCODEEXCHANGE)
    public Exchange sendSmsExchange(){
        return ExchangeBuilder.topicExchange(Constant.SENDSMSCODEEXCHANGE).build();
    }


    // 创建队列
    @Bean(Constant.SENDSMSCODEQUEUE)
    public Queue sendSmsQueue(){
        return QueueBuilder.durable(Constant.SENDSMSCODEQUEUE).build();
    }


    // 绑定交换机和队列
    @Bean
    public Binding sendSmsBinding(@Qualifier(Constant.SENDSMSCODEEXCHANGE) Exchange exchange, @Qualifier(Constant.SENDSMSCODEQUEUE) Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with(Constant.SENDSMSCODEROUTERKEY).noargs();
    }


}
