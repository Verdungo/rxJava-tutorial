package observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class ObservableWithoutBackpressure {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableWithoutBackpressure.class);

    public static void main(String[] args) {
        Observable<Integer> positiveNumberEvent = Observable.fromIterable(RxUtils.postiveNumbers(100000))
                .repeat()
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread());

        positiveNumberEvent.subscribe(new DemoObserver<>());
        RxUtils.sleep(100000);
    }
}
