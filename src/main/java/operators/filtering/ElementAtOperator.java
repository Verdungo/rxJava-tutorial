package operators.filtering;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementAtOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementAtOperator.class);

    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d", "e", "f")
                .elementAt(3)
                .subscribe(new MaybeObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onSubscribe");
                    }

                    @Override
                    public void onSuccess(String s) {
                        LOGGER.info("onSuccess -> {}", s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError -> {}", throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        LOGGER.info("onComplete");
                    }
                });
    }
}
