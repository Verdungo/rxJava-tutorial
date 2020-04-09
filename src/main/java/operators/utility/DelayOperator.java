package operators.utility;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class DelayOperator {
    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .delay(3, TimeUnit.SECONDS)
                .subscribe(new DemoObserver<>());
        RxUtils.sleep(5_000);
    }
}
