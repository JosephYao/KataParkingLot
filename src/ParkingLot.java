public class ParkingLot {
    private final int capacity;
    private int currentParkingId = 0;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return currentParkingId == capacity;
    }

    public int park() {
        return ++currentParkingId;
    }

    public void leave(int parkingId) {
        currentParkingId--;
    }
}
