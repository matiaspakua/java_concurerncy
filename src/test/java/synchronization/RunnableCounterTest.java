package synchronization;

import org.junit.jupiter.api.Test;

class RunnableCounterTest {

    @Test
    public void runnableCounterWithTwoThreadsTest() {
        /*
         * En este escenario, cada instancia de la clase runnable está
         * asociada a un "hilo" (thread) distinto, por lo tanto, las variables
         * que se instancian son privadas a cada hilo.
         */
        RunnableCounter runnableCounter1 = new RunnableCounter();
        Thread thread1 = new Thread(runnableCounter1, "Thread1");
        runnableCounter1.setNameOfThread("thread_1");

        RunnableCounter runnableCounter2 = new RunnableCounter();
        Thread thread2 = new Thread(runnableCounter2, "Thread2");
        runnableCounter2.setNameOfThread("thread___2");

        thread1.start();
        thread2.start();

        /*
         * Resultado: ambos contadores, de ambos thread han llegado a 99.
         */
    }

    @Test
    public void runnableCounterSingleThread() {
        /*
         * Este es un ejemplo de data RACE, ambos thread usan el mismo objeto
         * runnable y acceden a los mismo datos en un competición.
         */
        RunnableCounter runnableCounter = new RunnableCounter();
        runnableCounter.setNameOfThread("Single Runnable Thread");

        Thread thread1 = new Thread(runnableCounter, "thread_1");
        Thread thread2 = new Thread(runnableCounter, "thread_2");

        thread1.start();
        thread2.start();

        /*
         * Resultado: Solo un contador ha llegado a 99.
         */
    }
}