package observables;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.concurrent.atomic.AtomicInteger;

public class ObservableWithBackpressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithBackpressure.class);

    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.fromIterable(RxUtils.postiveNumbers(1000000))
                .repeat()
                .observeOn(Schedulers.newThread(), false, 5)
                .subscribeOn(Schedulers.newThread())
                .doOnNext(integer -> LOGGER.info("emitting integer -> {}", integer));

        flowable.subscribe(new Subscriber<>() {
            private Subscription subscription;
            private AtomicInteger counter = new AtomicInteger(0);

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                LOGGER.info("onSubscribe -> {}", subscription);
                subscription.request(5);
            }

            @Override
            public void onNext(Integer integer) {
                LOGGER.info("onNext -> {}", integer);
                //RxUtils.sleep(100);
                if (counter.incrementAndGet() % 5 == 0) {
                    subscription.request(5);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                LOGGER.info("onError -> {}", throwable.getMessage());
            }

            @Override
            public void onComplete() {
                LOGGER.info("onComplete");
            }
        });

        RxUtils.sleep(100000);
    }
}
