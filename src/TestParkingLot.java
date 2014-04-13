import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TestParkingLot {

    @Test
    public void parking_lot_is_not_full_at_very_beginning() {
        ParkingLot parkingLot = new ParkingLot(5);
        assertFalse(parkingLot.isFull());
    }
}
