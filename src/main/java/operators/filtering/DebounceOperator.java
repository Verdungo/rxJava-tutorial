package operators.filtering;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DebounceOperator {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        Observable.interval(1, TimeUnit.SECONDS)
                .map(c -> {
                    sb.append((char) ('a' + rand.nextInt(26)));
                    return sb.toString();
                })
                .subscribe(new DemoObserver<>());

        RxUtils.sleep(10_000);
    }
}
