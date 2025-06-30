package com.ichwan.message.pubsub;

import com.rabbitmq.client.*;

public class ConsumerApp {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://guest:guest@localhost:5672");
        factory.setVirtualHost("/");

        Channel channel = factory.newConnection().createChannel();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            System.out.println(delivery.getEnvelope().getRoutingKey());
            System.out.println(new String(delivery.getBody(), "UTF-8"));
        };

        CancelCallback cancelCallback = consumerTag -> {
            System.out.println("Consumer cancelled: " + consumerTag);
        };

        channel.basicConsume("email", true, deliverCallback, cancelCallback);
    }
}
