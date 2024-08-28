package synchronization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryManagementWithSyncTest {
    @Test
    public void inventoryManagementTest() {
        InventoryManagementWithSync inventoryManager = new InventoryManagementWithSync();
        Thread issuer = new Thread(inventoryManager, "issue");
        Thread receiver = new Thread(inventoryManager, "receive");

        issuer.start();
        receiver.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Current number of items in inventory: " + inventoryManager.getItemCount());

        // Debido a Data Race y corrupción del contador, nunca dará 200.000 items.
        Assertions.assertEquals(200_000, inventoryManager.getItemCount());
    }
}