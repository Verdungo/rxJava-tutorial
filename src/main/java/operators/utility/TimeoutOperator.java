package operators.utility;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class TimeoutOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Timeout Operator");

        Observable.fromIterable(RxUtils.shapes(3))
                .delay(1, TimeUnit.SECONDS)
                .timeout(2,TimeUnit.SECONDS)
                .timestamp().subscribe(new DemoObserver<>());
        RxUtils.sleep(10_000);
    }
}
