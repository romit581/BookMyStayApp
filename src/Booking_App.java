import java.util.Scanner;
public class Booking_App {
    public static void main(String[] args) {
        System.out.println("Booking Validation");
        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType, inventory);

            Reservation reservation = new Reservation(guestName, roomType + " Room");
            bookingQueue.addRequest(reservation);
            System.out.println("Booking successful for Guest: " + guestName
                    + ", Room Type: " + roomType);
        } catch (InvalidBookingException e){
            System.out.println("Booking Failed"+e.getMessage());
        }finally {
            scanner.close();
        }
    }
}