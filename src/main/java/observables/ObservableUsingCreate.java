package observables;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

import java.util.List;

public class ObservableUsingCreate {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObservableUsingJust.class);

    public static void main(String[] args) {
        List<Shape> shapes = RxUtils.shapes(5);
        Observable<Shape> observableUsingCreate =
        Observable.create(observableEmitter -> {
            try {
                shapes.forEach(observableEmitter::onNext);
            } catch (Exception e) {
                observableEmitter.onError(e);
            }
            observableEmitter.onComplete();
        });

        observableUsingCreate.subscribe(new DemoObserver<>());
        observableUsingCreate.subscribe(new DemoObserver<>());
    }
}
