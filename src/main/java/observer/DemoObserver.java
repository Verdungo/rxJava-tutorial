package observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import observables.ObservableUsingJust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoObserver<T> implements Observer<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingJust.class);

    @Override
    public void onSubscribe(Disposable disposable) {
        LOGGER.info("DemoObserver: onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        LOGGER.info("DemoObserver: onNext ->{}", o.toString());
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.info("DemoObserver: onError ->{}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        LOGGER.info("DemoObserver: onComplete");
    }
}
