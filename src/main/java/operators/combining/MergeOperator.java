package operators.combining;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import observer.DemoObserver;
import operators.filtering.TakeOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class MergeOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TakeOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Let's Merge!");

        Observable<String> o1 = Observable.interval(1000, TimeUnit.MILLISECONDS).map(l -> "First: " + l);
        Observable<String> o2 = Observable.interval(2500, TimeUnit.MILLISECONDS).map(l -> "Second: " + l);

        Observable<String> merged = Observable.merge(o1, o2);

        merged.subscribe(new DemoObserver<>());

        RxUtils.sleep(10_000);

    }
}
