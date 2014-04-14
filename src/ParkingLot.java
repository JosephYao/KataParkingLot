import java.util.Arrays;

public class ParkingLot {
    private final Boolean[] spaceAvailabilities;

    public ParkingLot(int capacity) {
        spaceAvailabilities = new Boolean[capacity];
        Arrays.fill(spaceAvailabilities, true);
    }

    public boolean isFull() {
        return Arrays.asList(spaceAvailabilities).indexOf(true) == -1;
    }

    public int park() {
        for (int space = 0; space < spaceAvailabilities.length; space++)
            if (spaceAvailabilities[space]) {
                spaceAvailabilities[space] = false;
                return parkingId(space);
            }
        throw new IllegalStateException();
    }

    private int parkingId(int space) {
        return space + 1;
    }

    public void leave(int parkingId) {
        spaceAvailabilities[spaceIndex(parkingId)] = true;
    }

    private int spaceIndex(int parkingId) {
        return parkingId - 1;
    }
}
