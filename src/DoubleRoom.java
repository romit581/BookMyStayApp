public class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.00);
    }
    @Override
    public void displayRoomDetails(){
        System.out.println("Double Room");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq ft");
        System.out.println("Price per night: " + pricePerNight);
    }
}
