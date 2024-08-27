package synchronization;

public class RunnableCounterDataRace implements Runnable{

    // Recurso compartido por los thread.
    private int counter;

    @Override
    public void run() {
        for (int i = 0; i <1_000_000; i++) {
            this.counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
