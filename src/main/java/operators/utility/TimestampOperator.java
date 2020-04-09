package operators.utility;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class TimestampOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimestampOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Timestamp Operator");

        Observable.fromIterable(RxUtils.shapes(10)).timestamp().subscribe(new DemoObserver<>());
    }
}
