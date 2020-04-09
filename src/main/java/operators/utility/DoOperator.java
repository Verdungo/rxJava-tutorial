package operators.utility;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class DoOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(5))
                .doOnEach(shapeNotification -> LOGGER.info("doOnEach -> {}", shapeNotification.getValue()))
                .doOnEach(shapeNotification -> LOGGER.info("doOnEach -> {}", shapeNotification))
                .doOnNext(shape -> LOGGER.info("doOnNext -> {}", shape))
                .doOnComplete(() -> LOGGER.info("doOnComplete"))
                .doOnSubscribe(disposable -> LOGGER.info("onSubscribe"))
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(5_000);
    }
}
