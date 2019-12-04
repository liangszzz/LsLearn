package rabbitmq.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicProducer {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try (Connection connection = factory.newConnection()) {

            Channel channel = connection.createChannel();
            String exchangeName = "topic-exchange";
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC);

            for (int i = 0; i < 10; i++) {
                String msg = "topic" + i;
                String routingKey;
                if (i % 2 == 0)
                    routingKey = "Tag";
                else routingKey = "Tag.A";
                channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
