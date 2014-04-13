import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestParkingLot {

    ParkingLot parkingLot = new ParkingLot(5);

    @Test
    public void parking_lot_is_not_full_when_just_opened() {
        assertFalse(parkingLot.isFull());
    }

    @Test
    public void can_park_car_when_parking_lot_is_just_opened() {
        assertNextParkingIdEquals(1);
    }

    @Test
    public void can_park_another_car_after_first_car_parked() {
        parkingLot.park();

        assertNextParkingIdEquals(2);
    }

    private void assertNextParkingIdEquals(int expectedParkingId) {
        int actualParkingId = parkingLot.park();

        assertEquals(expectedParkingId, actualParkingId);
    }
}
