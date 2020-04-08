package operators.filtering;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DebounceOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DebounceOperator.class);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        Observable.interval(2, TimeUnit.SECONDS)
                .map(c -> {
                    sb.append((char) ('a' + rand.nextInt(26)));
                    return sb.toString();
                })
                .doOnEach(notification -> LOGGER.info("Current -> {}", notification.getValue()))
                .debounce(1,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new DemoObserver<>());

        RxUtils.sleep(15_000);
    }
}
