package asynchronous;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class LongProcessingTaskFuture implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        System.out.println("Init processing of accounts: ");
        TimeUnit.SECONDS.sleep(4);
        return 1;
    }
}
