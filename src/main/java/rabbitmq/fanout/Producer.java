package rabbitmq.fanout;

import com.rabbitmq.client.*;

public class Producer {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("local.server");
        factory.setPort(5672);
        factory.setUsername("root");
        factory.setPassword("123456");

        try (Connection connection = factory.newConnection()) {

            Channel channel = connection.createChannel();
            String exchangeName = "fanout-exchange";
            channel.exchangeDeclare(exchangeName, BuiltinExchangeType.FANOUT);

            for (int i = 0; i < 10; i++) {
                String routingKey;
                String msg = "fanout" + i;

                if (i % 2 == 0) {
                    routingKey = "TAG.A";
                } else {
                    routingKey = "TAG.B";
                }
                channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
