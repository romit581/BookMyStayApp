import java.util.Map;

public class ReservationValidator {
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType + " Room")) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        if (availability.get(roomType + " Room") <= 0) {
            throw new InvalidBookingException("No available rooms for type: " + roomType);
        }
    }
}
