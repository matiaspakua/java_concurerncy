package synchronization;

public class SynchronizationAndVolatile implements Runnable {

    private int counter;

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {

            /*
            En este caso el monitor es el objecto actual (THIS).
             */
            synchronized (this) {
                // código critico, sincronizado, solo un thread puede acceder a la vez.
                counter++;
            }
        }
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(Thread.currentThread().getName() + " increased the counter up to: " +
                counter + " in " + elapsedTime / 1000000 + " milliseconds");
    }
}
