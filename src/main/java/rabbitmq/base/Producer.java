package rabbitmq.base;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare("hello", false, false, false, null);
            channel.basicPublish("", "hello", null, "msg2".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
