import java.util.Scanner;
public class Booking_App {
    public static void main(String[] args) {
        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        String filePath = "inventory.txt";

        // Try to load from file first
        persistenceService.loadInventory(inventory, filePath);

        // If inventory is empty (fresh start), initialize defaults
        if (inventory.getRoomAvailability().isEmpty()) {
            inventory.initializeInventory();
        }

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single Room"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double Room"));
        System.out.println("Suite: "  + inventory.getRoomAvailability().get("Suite Room"));

        // Save inventory to file
        persistenceService.saveInventory(inventory, filePath);
    }
}