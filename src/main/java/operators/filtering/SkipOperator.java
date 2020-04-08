package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class SkipOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(SkipOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .skip(4)
                .skipLast(2)
                .subscribe(new DemoObserver<>());
    }
}
