package com.itheima.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MqListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue(String msg){
        System.out.println("消费者收到了simple.queue的消息：【" + msg +"】");
    }

//    @RabbitListener(queues = "work.queue")
//    public void listenWorkQueue1(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 work.queue的消息：【" + msg +"】");
//        Thread.sleep(20);
//    }
//
//    @RabbitListener(queues = "work.queue")
//    public void listenWorkQueue2(String msg) throws InterruptedException {
//        System.err.println("消费者2 收到了 work.queue的消息...... ：【" + msg +"】");
//        Thread.sleep(200);
//    }
//
//    @RabbitListener(queues = "fanout.queue1")
//    public void listenFanoutQueue1(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 fanout.queue1的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "fanout.queue3")
//    public void listenFanoutQueue2(String msg) throws InterruptedException {
//        System.out.println("消费者2 收到了 fanout.queue3的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "direct.queue1")
//    public void listenDirectQueue1(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 fanout.queue1的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "topic.queue2")
//    public void listenTopicQueue2(String msg) throws InterruptedException {
//        System.out.println("消费者2 收到了 topic.queue2的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "topic.queue1")
//    public void listenTopicQueue1(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 topic.queue1的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "direct.queue2")
//    public void listenDirectQueue2(String msg) throws InterruptedException {
//        System.out.println("消费者2 收到了 fanout.queue3的消息：【" + msg +"】");
//    }

//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "direct.queue1", durable = "true"),
//            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
//            key = {"red", "blue"}
//    ),queuesToDeclare = @Queue(
//            name = "direct.queue1",
//            durable = "true",
//            arguments = @Argument(name = "x-queue-mode",value = "lazy")
//    ))
//    public void listenDirectQueue10(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 direct.queue1的消息：【" + msg +"】");
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(
                    name = "direct.queue1",
                    durable = "true",
                    arguments = @Argument(name = "x-queue-mode", value = "lazy") // 参数统一在这里声明
            ),
            exchange = @Exchange(
                    name = "hmall.direct",
                    type = ExchangeTypes.DIRECT
            ),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue10(String msg) {
        System.out.println("消费者1 收到了 direct.queue1的消息：【" + msg +"】");
    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "direct.queue2", durable = "true"),
//            exchange = @Exchange(name = "hmall.direct", type = ExchangeTypes.DIRECT),
//            key = {"red", "yellow"}
//    ))
//    public void listenDirectQueue2(String msg) throws InterruptedException {
//        System.out.println("消费者2 收到了 direct.queue2的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "topic.queue1")
//    public void listenTopicQueue1(String msg) throws InterruptedException {
//        System.out.println("消费者1 收到了 topic.queue1的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "topic.queue2")
//    public void listenTopicQueue2(String msg) throws InterruptedException {
//        System.out.println("消费者2 收到了 topic.queue2的消息：【" + msg +"】");
//    }
//
//    @RabbitListener(queues = "object.queue")
//    public void listenObject(Map<String, Object> msg) throws InterruptedException {
//        System.out.println("消费者 收到了 object.queue的消息：【" + msg +"】");
//    }
}
