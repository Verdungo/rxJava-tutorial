package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

import java.util.concurrent.TimeUnit;

public class ObservableUsingInterval {
    public static void main(String[] args) {
        Observable observableUsingInteerval = Observable.interval(1, TimeUnit.SECONDS);
        observableUsingInteerval.subscribe(new DemoObserver());

        RxUtils.sleep(5000);
    }
}
