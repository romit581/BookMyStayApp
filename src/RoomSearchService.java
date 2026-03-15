import java.util.Map;

public class RoomSearchService {
    public void searchAvailableRooms(RoomInventory inventory,Room singleRoom,Room doubleRoom,Room suiteRoom){
        Map<String,Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single Room")>0){
            singleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Single Room"));
            System.out.println();
        }
        if (availability.get("Double Room")>0){
            doubleRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Double Room"));
            System.out.println();
        }
        if (availability.get("Suite Room")>0){
            suiteRoom.displayRoomDetails();
            System.out.println("Available: " + availability.get("Suite Room"));
            System.out.println();
        }

    }
}
