
public class Booking_App {
    public static void main(String[] args) {

        // Print a welcome message to the console
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom  = new SuiteRoom();

        // Static availability stored as simple variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability  = 2;

        // Display room details and availability
        System.out.println("Hotel Room Initialization");
        System.out.println();

        singleRoom.displayRoomDetails();
        System.out.println("Available: " + singleRoomAvailability);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleRoomAvailability);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available: " + suiteRoomAvailability);


    }
}
