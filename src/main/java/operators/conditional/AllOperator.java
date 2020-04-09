package operators.conditional;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class AllOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AllOperator.class);

    public static void main(String[] args) {
        LOGGER.info("All Operator");
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .all(i -> i<100)
                .subscribe(new SingleObserver<>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onubscribe");
                    }

                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        LOGGER.info("All emits are < 100 : {}", aBoolean);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError: {}", throwable.getMessage());
                    }
                });
    }
}
