package synchronization;

public class InventoryManagementWithoutSync implements Runnable{

    private int itemCount = 200_000;

    @Override
    public void run() {
        String function = Thread.currentThread().getName();

        if(function.equals("issue")) {
            for(int i = 0; i < 100000; i++) {
                itemCount--;
            }
        } else if(function.equals("receive")) {
            for(int i = 0; i < 100000; i++) {
                itemCount++;
            }
        }
    }

    public int getItemCount() {
        return itemCount;
    }
}
