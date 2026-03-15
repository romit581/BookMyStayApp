public class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 200, 1500.00);
    }
    @Override
    public void displayRoomDetails(){

        System.out.println("Single Room");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq ft");
        System.out.println("Price per night: " + pricePerNight);
    }
}
