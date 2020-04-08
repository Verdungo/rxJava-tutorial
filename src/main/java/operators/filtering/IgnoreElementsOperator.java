package operators.filtering;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class IgnoreElementsOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementAtOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.primeNumbers(10))
                .ignoreElements()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        LOGGER.info("onComplete");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError -> {}", throwable.getMessage());
                    }
                });
    }
}
