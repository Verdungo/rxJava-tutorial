package operators.combining;

import io.reactivex.Observable;
import observer.DemoObserver;
import operators.filtering.TakeOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class CombineLatest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CombineLatest.class);

    public static void main(String[] args) {
        LOGGER.info("CombineLatest class");

        Observable<Long> o1 = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Observable<Long> o2 = Observable.interval(2500, TimeUnit.MILLISECONDS);

        Observable<String> combined = Observable.combineLatest(o1, o2,
                (l1, l2) -> "First = " + l1 + ". Second = " + l2);

        combined.subscribe(new DemoObserver<>());

        RxUtils.sleep(20_000);
    }
}
