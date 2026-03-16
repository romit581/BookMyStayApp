import java.util.Scanner;
public class Booking_App {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();

        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        CancellationService cancellationService = new CancellationService();

        Reservation r1 = new Reservation("Abhi",     "Single Room");
        Reservation r2 = new Reservation("Subha",    "Double Room");
        Reservation r3 = new Reservation("Vanmathi", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
            cancellationService.registerBooking(next.getRoomId(), next.getRoomType());
        }

        System.out.println("Booking Cancellation");

        // Cancel only Abhi's booking
        cancellationService.cancelBooking(r1.getRoomId(), inventory);

        // Show rollback history and updated inventory
        cancellationService.showRollbackHistory(inventory);
    }
}