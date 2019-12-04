package rabbitmq.work;

import com.rabbitmq.client.*;

public class WorkProducer {
    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            String queueName = "test-work";
            channel.queueDeclare(queueName, true, false, false, null);
            for (int i = 0; i < 10; i++) {
                channel.basicPublish("", queueName, MessageProperties.PERSISTENT_TEXT_PLAIN, ("some message" + i).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
