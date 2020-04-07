package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class ObservableUsingTmer {
    public static void main(String[] args) {
        Observable<Long> observableUsingInteerval = Observable.timer(2, TimeUnit.SECONDS);
        observableUsingInteerval.subscribe(new DemoObserver<>());

        RxUtils.sleep(5000);

    }
}
