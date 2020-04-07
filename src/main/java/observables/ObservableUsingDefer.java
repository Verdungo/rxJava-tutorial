package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class ObservableUsingDefer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingJust.class);

    public static void main(String[] args) {
        Observable<Integer> observableUsingDefer = Observable.defer(
                () -> Observable.fromIterable(RxUtils.postiveNumbers(5)
        ));

        observableUsingDefer.subscribe(new DemoObserver<>());
        observableUsingDefer.subscribe(new DemoObserver<>());
    }
}
