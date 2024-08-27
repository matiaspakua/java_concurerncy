package synchronization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RunnableCounterDataRaceTest {

    @Test
    public void runnableCounterDataRaceTest(){

        RunnableCounterDataRace runnableCounterDataRace = new RunnableCounterDataRace();

        Thread thread1 = new Thread(runnableCounterDataRace, "Thread_1");
        Thread thread2 = new Thread(runnableCounterDataRace, "thread_2");

        thread1.start();
        thread2.start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        System.out.println(runnableCounterDataRace.getCounter());
        Assertions.assertNotEquals(0, runnableCounterDataRace.getCounter());
    }

}