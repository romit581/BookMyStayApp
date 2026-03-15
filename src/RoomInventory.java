import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String,Integer> roomAvailability;
    public RoomInventory(){
        roomAvailability = new HashMap<>();
    }
    public void initializeInventory(){
        roomAvailability.put("Single Room", 5);
        roomAvailability.put("Double Room", 3);
        roomAvailability.put("Suite Room",  2);
    }
    public Map<String,Integer> getRoomAvailability() {return roomAvailability; }

    public void updateAvailability(String roomType, int count){
        roomAvailability.put(roomType,count);
    }
    public void displayInventory() {
        System.out.println("--------------------------------------------");
        System.out.println("Current Room Inventory:");
        System.out.println("--------------------------------------------");
        for (Map.Entry<String, Integer> entry : roomAvailability.entrySet()) {
            System.out.println("  " + entry.getKey() + " : " + entry.getValue() + " available");
        }
        System.out.println("--------------------------------------------");
    }
}
