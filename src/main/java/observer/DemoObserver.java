package observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoObserver<T> implements Observer<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(Observer.class);

    @Override
    public void onSubscribe(Disposable disposable) {
        LOGGER.info("onSubscribe");
    }

    @Override
    public void onNext(Object o) {
        LOGGER.info("onNext -> {}", o.toString());
    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.info("onError -> {}", throwable.getMessage());
    }

    @Override
    public void onComplete() {
        LOGGER.info("onComplete");
    }
}
