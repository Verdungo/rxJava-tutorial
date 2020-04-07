package observables;

import io.reactivex.Observable;
import observer.DemoObserver;
import utils.RxUtils;

import java.util.concurrent.Callable;

public class ObservableUsingFromCallable {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return doJob();
            }
        };
        Observable.fromCallable(callable).subscribe(new DemoObserver<>());
    }

    private static String doJob() {
        RxUtils.sleep(2000);
        return "Job completed!";
    }
}
