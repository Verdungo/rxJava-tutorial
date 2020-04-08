package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

public class ScanOperator {
    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                .scan((x, y) -> x + y)
                .subscribe(new DemoObserver<>());
    }
}
