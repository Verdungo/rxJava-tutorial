package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObservableUsingJust {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingJust.class);

    public static void main(String... args) {
        Observable.just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
                .subscribe(new DemoObserver<>());
    }
}
