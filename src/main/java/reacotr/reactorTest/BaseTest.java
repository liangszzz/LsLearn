package reacotr.reactorTest;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class BaseTest {


    public static void main(String[] args) throws InterruptedException {

        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {

            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("subscriber onSubscribe");
                subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                System.out.println("subscriber onNext:item" + item);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("subscriber onError" + throwable);
            }

            @Override
            public void onComplete() {
                System.out.println("subscriber onComplete");
            }
        };

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        publisher.subscribe(subscriber);

        for (int i = 0; i < 100; i++) {
            publisher.submit("submit:" + i);
        }

        Thread.currentThread().join(100000000);

    }

}
