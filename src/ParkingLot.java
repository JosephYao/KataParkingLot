import java.util.Arrays;

public class ParkingLot {
    private final Boolean[] spaceAvailabilities;

    public ParkingLot(int capacity) {
        spaceAvailabilities = new Boolean[capacity + 1];
        Arrays.fill(spaceAvailabilities, true);
    }

    public boolean isFull() {
        return Arrays.asList(spaceAvailabilities).lastIndexOf(true) == 0;
    }

    public int park() {
        for (int space = 1; space < spaceAvailabilities.length; space++)
            if (spaceAvailabilities[space]) {
                spaceAvailabilities[space] = false;
                return space;
            }
        throw new IllegalStateException();
    }

    public void leave(int parkingId) {
        spaceAvailabilities[parkingId] = true;
    }
}
