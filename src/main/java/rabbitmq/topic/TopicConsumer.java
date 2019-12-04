package rabbitmq.topic;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class TopicConsumer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String exchangeName = "topic-exchange";
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);

            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, exchangeName, "Tag.*");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
