package synchronization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SynchronizationAndVolatileTest {

    private static SynchronizationAndVolatile synchronizationAndVolatileClass;

    @BeforeAll
    public static void init() {
        synchronizationAndVolatileClass = new SynchronizationAndVolatile();
    }

    @Test
    public void synchronizationRunnableTest() {

        Thread thread1 = new Thread(synchronizationAndVolatileClass, "Thread1");
        Thread thread2 = new Thread(synchronizationAndVolatileClass, "Thread2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final value of counter is: " + synchronizationAndVolatileClass.getCounter());

        /*
        Resultado esperado:

            Thread1 increased the counter up to: 2000000 in 70 milliseconds
            Thread2 increased the counter up to: 1966340 in 70 milliseconds
            Final value of counter is: 2000000
         */

        Assertions.assertEquals(2_000_000, synchronizationAndVolatileClass.getCounter());
    }

}