public class Booking_App {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();

        RoomAllocationService allocationService = new RoomAllocationService();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        BookingHistory bookingHistory = new BookingHistory();

        Reservation r1 = new Reservation("Abhi",     "Single Room");
        Reservation r2 = new Reservation("Subha",    "Double Room");
        Reservation r3 = new Reservation("Vanmathi", "Suite Room");

        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        while (bookingQueue.hasPendingRequests()) {
            Reservation next = bookingQueue.getNextRequest();
            allocationService.allocateRoom(next, inventory);
            bookingHistory.addReservation(next);
        }

        // UC8 - Booking History & Reporting
        BookingReportService reportService = new BookingReportService();

        System.out.println("Booking History and Reporting");
        System.out.println();
        System.out.println("Booking History Report");
        reportService.generateReport(bookingHistory);
    }
}