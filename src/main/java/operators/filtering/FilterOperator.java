package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RxUtils;

public class FilterOperator {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterOperator.class);

    public static void main(String[] args) {
        Observable.fromIterable(RxUtils.shapes(30))
                .filter(shape -> "green".equals(shape.getColor()) && "square".equals(shape.getShape()))
                .subscribe(new DemoObserver<>());
    }
}
