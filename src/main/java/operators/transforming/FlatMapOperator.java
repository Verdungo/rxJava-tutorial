package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.List;

public class FlatMapOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlatMapOperator.class);

    public static void main(String[] args) {
        LOGGER.info("FlatMapOperator class");
        List<Integer> positiveNumbers = RxUtils.postiveNumbers(10);

        Observable.fromIterable(positiveNumbers)
                .flatMap((Function<Integer, ObservableSource<?>>) FlatMapOperator::twice).subscribe(new DemoObserver<>());
    }

    public static Observable<Integer> twice(Integer integer) {
        return Observable.create(observableEmitter -> {
            if (!observableEmitter.isDisposed()) {
                observableEmitter.onNext(integer);
            } else {
                observableEmitter.onComplete();
            }
        });
    }
}
