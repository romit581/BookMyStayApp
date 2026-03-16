public class Booking_App {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();

        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        Reservation r1 = new Reservation("Abhi",     "Single Room");
        Reservation r2 = new Reservation("Subha",    "Double Room");
        Reservation r3 = new Reservation("Vanmathi", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
        }

        // UC7 - Add-On Service Selection
        AddOnServiceManager serviceManager = new AddOnServiceManager();
        serviceManager.addService(r1.getRoomId(), new AddOnService("Spa", 1500.00));

        System.out.println("Add-On Service Selection");
        serviceManager.displayServices(r1.getRoomId());
    }
}