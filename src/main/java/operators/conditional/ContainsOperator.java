package operators.conditional;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class ContainsOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContainsOperator.class);

    public static void main(String[] args) {
        LOGGER.info("Contains Operator");
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .contains(29)
                .subscribe(new SingleObserver<>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("onSubscribe");
                    }

                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        LOGGER.info("Obs contains \"29\" : {}", aBoolean);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("onError: {}", throwable.getMessage());
                    }
                });
    }
}
