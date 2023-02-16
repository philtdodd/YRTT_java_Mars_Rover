package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void getLocation() {
        Vehicle vehicle = new Vehicle(1, 1, Compass.NORTH, 3, 3);

        assertEquals("1 1 N", vehicle.getLocation());
    }

    @Test
    void move() {
        Vehicle vehicle = new Vehicle(1, 1, Compass.NORTH, 3, 3);

        GridReference newLocation = vehicle.move();

        assertEquals(1, newLocation.getX());
        assertEquals(2, newLocation.getY());
    }
}