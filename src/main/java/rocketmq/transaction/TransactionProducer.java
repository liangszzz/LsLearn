package rocketmq.transaction;

import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.TimeUnit;

public class TransactionProducer {

    public static void main(String[] args) throws Exception {
        TransactionMQProducer producer = new TransactionMQProducer("test_group");
        producer.setNamesrvAddr("localhost:9876");
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                if (msg.getTags().equals("TAG_A"))
                    return LocalTransactionState.COMMIT_MESSAGE;
                else if (msg.getTags().equals("TAG_B"))
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                else
                    return LocalTransactionState.UNKNOW;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                if (msg.getTags().equals("TAG_C"))
                    return LocalTransactionState.COMMIT_MESSAGE;
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }
        });
        producer.start();
        for (int i = 0; i < 10; i++) {
            String tag = "";
            if (i % 3 == 0) {
                tag = "TAG_A";
            } else if (i % 3 == 1) {
                tag = "TAG_B";
            } else tag = "TAG_C";
            Message message = new Message("base_topic", tag, ("order" + i).getBytes());
            SendResult send = producer.sendMessageInTransaction(message, null);
            System.out.println(send);
        }
        TimeUnit.SECONDS.sleep(100);
        producer.shutdown();
    }
}
