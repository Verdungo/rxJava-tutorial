package observables;

import io.reactivex.Observable;
import observer.DemoObserver;

public class ObservableUsingRange {
    public static void main(String[] args) {
        Observable<Integer> observableUsingRange = Observable.range(4,7);
        observableUsingRange.subscribe(new DemoObserver<>());
    }
}
