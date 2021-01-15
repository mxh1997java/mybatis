package com.emi2c.mybatis.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * messageQueue消息消费者
 */
@Component
@RabbitListener(queues = "messageQueue")
public class MessageQueueConsumer {

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void receive(String msg) {
        System.out.println("[messageQueue] receive message: " + msg);
    }

}
