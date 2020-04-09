package operators.combining;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class ZipOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZipOperator.class);

    public static void main(String[] args) {
        LOGGER.info("ZZZzzZZzZIP!");

        Observable<String> o1 = Observable.interval(1, TimeUnit.SECONDS).map(l -> "first: " + l).doOnNext(LOGGER::info);
        Observable<String> o2 = Observable.interval(2, TimeUnit.SECONDS).map(l -> "second: " + l).doOnNext(LOGGER::info);

        Observable<String> zipped = Observable.zip(o1, o2, (s1,s2) -> s1 + " | " + s2);

        zipped.subscribe(new DemoObserver<>());

        RxUtils.sleep(10_000);

        /*Observable o1 = Observable.fromIterable(RxUtils.shapes(5)).doOnNext(shape -> LOGGER.info("new shape {}", shape));
        Observable o2 = Observable.fromIterable(RxUtils.postiveNumbers(3)).doOnNext(shape -> LOGGER.info("new int {}", shape));

        Observable zipped = Observable.zip(o1,o2, (s, i) -> s + " " + i);

        zipped.subscribe(new DemoObserver());*/
    }
}
