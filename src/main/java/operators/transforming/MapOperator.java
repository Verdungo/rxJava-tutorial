package operators.transforming;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import models.Shape;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class MapOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapOperator.class);

    public static void main(String[] args) {
        //Observable.fromIterable(RxUtils.shapes(10))
        Observable.fromIterable(RxUtils.postiveNumbers(10))
                /*.map(new Function<Shape, String>() {
                    @Override
                    public String apply(Shape shape) throws Exception {
                        return "CUSTOM STR: " + shape.getColor() + " " + shape.getShape();
                    }
                })*/
                .doOnNext(s -> LOGGER.info("{}",s))
                .map(s -> "doubled: " + s*2)
                .subscribe(new DemoObserver<>());
    }
}
