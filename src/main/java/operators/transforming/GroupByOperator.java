package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class GroupByOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GroupByOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(20))
                .groupBy(new Function<Shape, String>() {        // можно заменить 'shape -> shape.getShape()' или даже 'Shape::getShape', но так нагляднее
                    @Override
                    public String apply(Shape shape) throws Exception {
                        return shape.getShape();
                    }
                }).observeOn(Schedulers.newThread())    //в отдельном потоке, чтобы увидеть результат по завершению
                .subscribe(new Observer<GroupedObservable<String, Shape>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        LOGGER.info("GROUP onSubscribe");
                    }

                    @Override
                    public void onNext(GroupedObservable<String, Shape> objectShapeGroupedObservable) {
                        LOGGER.info("key -> {}", objectShapeGroupedObservable.getKey());

                        objectShapeGroupedObservable.subscribe(new DemoObserver<>());
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LOGGER.info("GROUP onError");
                    }

                    @Override
                    public void onComplete() {
                        LOGGER.info("GROUP onComplete");
                    }
                });

        RxUtils.sleep(10000);
    }
}
