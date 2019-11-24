package rocketmq.broadcast;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class BroadcastProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        Message message = new Message("base_topic", "Tag_A", "Broadcast".getBytes());
        SendResult send = producer.send(message);
        System.out.println(send);
        producer.shutdown();
    }
}
