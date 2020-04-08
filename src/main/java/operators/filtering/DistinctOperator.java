package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;

public class DistinctOperator {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,1,3,5,6)
                .distinct()
                .subscribe(new DemoObserver<>());
    }
}
