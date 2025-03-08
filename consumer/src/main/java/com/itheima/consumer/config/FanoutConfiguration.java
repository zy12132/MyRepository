package com.itheima.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfiguration {

    //定义交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        // ExchangeBuilder.fanoutExchange("").build();
        return new FanoutExchange("cqupt.fanout1");
    }

    //定义队列
    @Bean
    public Queue fanoutQueue1(){
        // QueueBuilder.durable("ff").build();
        return new Queue("cqupt.queue1");
    }

    //建立连接
    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue1, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    //定义队列
    @Bean
    public Queue fanoutQueue2(){
        return new Queue("cqupt.queue2");
    }

    @Bean
    public Binding fanoutBinding4(){
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }
}
