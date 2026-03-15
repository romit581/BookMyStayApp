public class SuiteRoom extends Room{
    public SuiteRoom() {
        super(3, 750, 5000.00);
    }
    @Override
    public void displayRoomDetails(){
        System.out.println("Suite Room");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq ft");
        System.out.println("Price per night: " + pricePerNight);
    }
}
