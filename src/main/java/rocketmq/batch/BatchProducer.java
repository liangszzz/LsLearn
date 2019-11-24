package rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

public class BatchProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        List<Message> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base_topic", "Tag_A", ("batch" + i).getBytes());
            message.putUserProperty("i", String.valueOf(i));
            list.add(message);
        }
        SendResult send = producer.send(list);
        System.out.println(send);
        producer.shutdown();
    }
}
