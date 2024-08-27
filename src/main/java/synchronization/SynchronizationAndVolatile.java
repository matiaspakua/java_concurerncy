package synchronization;

public class SynchronizationAndVolatile {

    private String accountToValidate = "test";

    public synchronized boolean methodSynchronization(float amount){
        // La sección critica va aqui:

        // if ( accountOrigin.hasMoney(amount)){
        //      accountOrigin.withdraw(amount);
        //      accountDestiny.deposit(amount);
        //      return true;
        // } else {
        //      return false;
        // }
        return true;
    }

    public void objectSynchronization(){

        synchronized(accountToValidate){
            // La sección critica va aqui:
            // ejecutar alguna validación en la cuenta
            accountToValidate = "valid";
        }
    }
}
