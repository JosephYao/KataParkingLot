import org.junit.Test;

import static org.junit.Assert.*;

public class TestParkingLot {

    private static final int CAPACITY = 5;
    ParkingLot parkingLot = new ParkingLot(CAPACITY);

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
        parkCarsToCapacity();

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

    @Test(expected = NoAvailableSpaceException.class)
    public void throw_exception_when_park_car_while_parking_lot_is_already_full() {
        parkCarsToCapacity();

        parkCars(1);
    }

    @Test(expected = InvalidParkingIdException.class)
    public void throw_exception_when_leave_car_with_parking_id_smaller_than_the_smallest_possible_id() {
        parkingLot.leave(0);
    }

    @Test(expected = InvalidParkingIdException.class)
    public void throw_exception_when_leave_car_with_parking_id_bigger_than_the_biggest_possible_id() {
        parkingLot.leave(CAPACITY + 1);
    }

    @Test(expected = InvalidParkingIdException.class)
    public void throw_exception_when_leave_car_with_parking_id_belong_to_an_available_space() {
        parkingLot.leave(1);
    }

    private void parkCarsToCapacity() {
        parkCars(CAPACITY);
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
