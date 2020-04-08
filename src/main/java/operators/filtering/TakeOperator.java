package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class TakeOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TakeOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .take(7)
                .takeLast(2)
                .subscribe(new DemoObserver<>());
    }
}
