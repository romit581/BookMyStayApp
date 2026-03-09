
public class Booking_App {
    public static void main(String[] args) {

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom  = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();
        inventory.initializeInventory();
        RoomSearchService searchService = new RoomSearchService();

        // Display room details and availability

        System.out.println("Room Search");
        System.out.println();
        searchService.searchAvailableRooms(inventory, singleRoom, doubleRoom, suiteRoom);


    }
}
