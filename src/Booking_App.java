import java.util.Scanner;
public class Booking_App {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();

        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Add 4 guests
        bookingQueue.addRequest(new Reservation("Abhi",     "Single Room"));
        bookingQueue.addRequest(new Reservation("Vanmathi", "Double Room"));
        bookingQueue.addRequest(new Reservation("Kural",    "Suite Room"));
        bookingQueue.addRequest(new Reservation("Subha",    "Single Room"));

        System.out.println("Concurrent Booking Simulation");

        // Create two booking processor threads sharing the same queue, inventory, service
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );
        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // Start concurrent processing
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        // Display remaining inventory
        System.out.println("\nRemaining Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single Room"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double Room"));
        System.out.println("Suite: "  + inventory.getRoomAvailability().get("Suite Room"));
    }
}