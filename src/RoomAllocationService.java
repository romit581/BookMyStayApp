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

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType) || availability.get(roomType) <= 0) {
            return;
        }

        String roomId = generateUniqueRoomId(roomType);
        allocatedRoomIds.add(roomId);
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.updateAvailability(roomType, availability.get(roomType) - 1);
        reservation.setRoomId(roomId);
    }

    private String generateUniqueRoomId(String roomType) {
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

    public Set<String> getAllocatedRoomIds() {
        return Collections.unmodifiableSet(allocatedRoomIds);
    }

    public Map<String, Set<String>> getAssignedRoomsByType() {
        return Collections.unmodifiableMap(assignedRoomsByType);
    }
}