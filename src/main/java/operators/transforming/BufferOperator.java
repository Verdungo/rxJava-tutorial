package operators.transforming;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class BufferOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(BufferOperator.class);

    public static void main(String[] args) {
        // так получим 10 эмиттов с Shape в каждом
        Observable.fromIterable(RxUtils.shapes(10)).subscribe(new DemoObserver<>());
        // так получим 4 эмита с List<Shape> размера 3 (последний - сколько останется)
        Observable.fromIterable(RxUtils.shapes(10)).buffer(3).subscribe(new DemoObserver<>());
    }
}
