
public class Booking_App {
    public static void main(String[] args) {

        // Print a welcome message to the console
        System.out.println("Welcome to the Hotel Booking Management System");
        System.out.println("System initialized successfully.");

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom  = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();

        // Display room details and availability
        System.out.println("Hotel Room Inventory Status");
        System.out.println();

        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single Room"));
        System.out.println();

        // Display Double Room details + availability
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double Room"));
        System.out.println();

        // Display Suite Room details + availability
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite Room"));
        System.out.println();


    }
}
