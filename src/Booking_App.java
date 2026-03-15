
public class Booking_App {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();
        inventory.displayInventory();

        // Setup allocation service
        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Guests submit booking requests — added in arrival order
        Reservation r1 = new Reservation("Abhi","Single");
        Reservation r2 = new Reservation("Subha","Double");
        Reservation r3 = new Reservation("Vanmathi","Suite");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        System.out.println("Room Allocation Processing");

        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
        }

        allocationService.printSummary(inventory);



    }
}
