import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        parkCars(1);

        assertNextParkingIdEquals(2);
    }

    @Test
    public void parking_lot_is_full_when_car_parked_to_its_capacity() {
        parkCars(5);

        assertTrue(parkingLot.isFull());
    }

    @Test
    public void can_park_another_car_after_parked_car_left() {
        parkCars(1);
        parkingLot.leave(1);

        assertNextParkingIdEquals(1);
    }

    @Test
    public void parking_id_is_1_when_first_parked_car_leave_and_second_car_still_there() {
        parkCars(2);
        parkingLot.leave(1);

        assertNextParkingIdEquals(1);
    }

    private void parkCars(int number) {
        for (int i = 0; i < number; i++)
            parkingLot.park();
    }

    private void assertNextParkingIdEquals(int expectedParkingId) {
        int actualParkingId = parkingLot.park();

        assertEquals(expectedParkingId, actualParkingId);
    }
}
