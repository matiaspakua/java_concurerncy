package asynchronous;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

class LongProcessingTaskFutureTest {

    @Test
    public void ExecutableServiceTest() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();
        Future<Integer> future1 = executorService.submit(new LongProcessingTaskFuture());
        Future<Integer> future2 = executorService.submit(new GenerateStatisticsAccountsTask());

        while (!future1.isDone() && !future2.isDone()) {
            System.out.println("Reading and processing not yet finished.");
            // Simulating another task
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(future1.get());
        System.out.println(future2.get());

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime / 1000000) / 1000 + " seconds");

        executorService.shutdown();
    }
}