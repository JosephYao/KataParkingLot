import java.util.Arrays;

public class ParkingLot {
    private int currentParkingId = 0;

    private final boolean[] spaceAvailabilities;

    public ParkingLot(int capacity) {
        spaceAvailabilities = new boolean[capacity + 1];
        Arrays.fill(spaceAvailabilities, true);
    }

    public boolean isFull() {
        return currentParkingId == spaceAvailabilities.length - 1;
    }

    public int park() {
        for (int space = 1; space < spaceAvailabilities.length; space++)
            if (spaceAvailabilities[space]) {
                spaceAvailabilities[space] = false;
                currentParkingId++;
                return space;
            }
        throw new IllegalStateException();
    }

    public void leave(int parkingId) {
        spaceAvailabilities[parkingId] = true;
        currentParkingId--;
    }
}
