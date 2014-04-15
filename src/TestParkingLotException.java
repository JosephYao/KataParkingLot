import org.junit.Test;

public class TestParkingLotException {
    private static final int CAPACITY = 5;
    ParkingLot parkingLot = new ParkingLot(CAPACITY);

    @Test(expected = NoAvailableSpaceException.class)
    public void throw_exception_when_park_car_while_parking_lot_is_already_full() {
        parkCars(CAPACITY);

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

    private void parkCars(int number) {
        for (int i = 0; i < number; i++)
            parkingLot.park();
    }

}
