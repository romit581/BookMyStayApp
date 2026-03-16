import java.util.ArrayList;
import java.util.List;

public class BookingHistory {
    private List<Reservation> confirmedReservations;

    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }

    public void displayHistory() {
        System.out.println("Booking History Report");
        for (Reservation r : confirmedReservations) {
            String shortType = r.getRoomType().replace(" Room", "");
            System.out.println("Guest: " + r.getGuestName() + ", Room Type: " + shortType);
        }
    }
}