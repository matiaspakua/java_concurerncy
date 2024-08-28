package synchronization;

public class InventoryManagementWithSync implements Runnable{

    private int itemCount = 200_000;

    @Override
    public void run() {
        String function = Thread.currentThread().getName();

        if(function.equals("issue")) {
            for(int i = 0; i < 100000; i++) {
                synchronized (this) {
                    itemCount--;
                }
            }
        } else if(function.equals("receive")) {
            for(int i = 0; i < 100000; i++) {
                synchronized (this){
                    itemCount++;
                }
            }
        }
    }

    public int getItemCount() {
        return itemCount;
    }
}
