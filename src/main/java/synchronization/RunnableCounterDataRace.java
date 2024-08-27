package synchronization;

public class RunnableCounterDataRace implements Runnable{

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
