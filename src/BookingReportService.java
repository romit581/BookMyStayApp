import java.util.List;

public class BookingReportService {

    public void generateReport(BookingHistory bookingHistory) {
        List<Reservation> bookings = bookingHistory.getConfirmedReservations();
        for (Reservation r : bookings) {
            String shortType = r.getRoomType().replace(" Room", "");
            System.out.println("Guest: " + r.getGuestName() + ", Room Type: " + shortType);
        }
    }
}