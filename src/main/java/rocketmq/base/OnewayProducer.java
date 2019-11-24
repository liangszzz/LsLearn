package rocketmq.base;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

public class OnewayProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        Message message = new Message("base_topic", "Tag_A", "one way".getBytes());
        producer.sendOneway(message);
        producer.shutdown();
    }
}
