package rocketmq.order;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class OrderedProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base_topic", "Tag_C", ("order" + i).getBytes());
            SendResult send = producer.send(message, (mqs, msg, arg) -> {
                int index = (int) arg;
                return mqs.get(index % mqs.size());
            }, i);
            System.out.println(send);
        }

        producer.shutdown();
    }
}
