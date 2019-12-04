package rabbitmq.routing;

import com.rabbitmq.client.*;

import java.nio.charset.StandardCharsets;

public class RoutingConsumer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            String exchangeName = "routing-exchange";
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);

            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, exchangeName, "TAG");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "    " + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
