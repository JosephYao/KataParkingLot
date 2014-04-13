public class ParkingLot {
    private int currentParkingId = 0;

    public ParkingLot(int capacity) {

    }

    public boolean isFull() {
        return false;
    }

    public int park() {
        return ++currentParkingId;
    }
}
