package com.ichwan.message.pubsub;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Map;

public class ProducerApp {

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setUri("amqp://guest:guest@localhost:5672");
        factory.setConnectionTimeout(60000);

        Channel channel = factory.newConnection().createChannel();

        for (int i = 0; i < 10; i++) {
            String message = "Hello World " + i;
            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .headers(Map.of("sample","test"))
                    .build();

            channel.basicPublish("notification","email", properties, message.getBytes());
        }

        channel.close();
        factory.newConnection().close();
    }
}
