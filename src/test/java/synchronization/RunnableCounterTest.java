package synchronization;

import org.junit.jupiter.api.Test;

class RunnableCounterTest {

    @Test
    public void simpleRunnableCounterTest() {
        RunnableCounter runnableCounter1 = new RunnableCounter();
        Thread thread1 = new Thread(runnableCounter1, "Thread1");
        runnableCounter1.nameOfThread("thread_1");

        RunnableCounter runnableCounter2 = new RunnableCounter();
        Thread thread2 = new Thread(runnableCounter2, "Thread2");
        runnableCounter2.nameOfThread("thread___2");

        thread1.start();
        thread2.start();
    }
}