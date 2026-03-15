import java.util.*;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        String guestName = reservation.getGuestName();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType) || availability.get(roomType) <= 0) {
            System.out.println("  [FAILED] No available rooms of type: " + roomType);
            return;
        }

        // Generate unique room ID
        String roomId = generateUniqueRoomId(roomType);

        // Record globally to prevent reuse
        allocatedRoomIds.add(roomId);

        // Record under room type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Decrement inventory immediately
        inventory.updateAvailability(roomType, availability.get(roomType) - 1);

        // Exact output format
        System.out.println("Booking confirmed for Guest: " + guestName + ", Room ID: " + roomId);
    }

    private String generateUniqueRoomId(String roomType) {
        // Extract short name: "Single Room" -> "Single", "Suite Room" -> "Suite"
        String shortName = roomType.replace(" Room", "");

        int counter = assignedRoomsByType
                .getOrDefault(roomType, Collections.emptySet())
                .size() + 1;

        String roomId;
        do {
            roomId = shortName + "-" + counter;
            counter++;
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }

    public void printSummary(RoomInventory inventory) {
        System.out.println("\n=== Final Allocated Rooms ===");
        for (Map.Entry<String, Set<String>> entry : assignedRoomsByType.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\n=== Remaining Inventory ===");
        for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " room(s) left");
        }
    }

    public Set<String> getAllocatedRoomIds() {
        return Collections.unmodifiableSet(allocatedRoomIds);
    }

    public Map<String, Set<String>> getAssignedRoomsByType() {
        return Collections.unmodifiableMap(assignedRoomsByType);
    }
}