import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {
    private Map<String, List<AddOnService>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {
        reservationServices
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public double calculateTotalCost(String reservationId) {
        double total = 0;
        for (AddOnService s : reservationServices.getOrDefault(reservationId, new ArrayList<>())) {
            total += s.getServiceCost();
        }
        return total;
    }

    public void displayServices(String reservationId) {
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + calculateTotalCost(reservationId));
    }
}