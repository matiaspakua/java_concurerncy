package asynchronous;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class GenerateStatisticsAccountsTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Generate statistics of accounts");
        TimeUnit.SECONDS.sleep(6);
        return 0;
    }
}
