package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void getLocation() {
        Vehicle vehicle = new Vehicle(1, 1, Compass.NORTH, 3, 3, true, 1);

        assertEquals("1 1 N", vehicle.getLocation());
    }

    @Test
    void move() {
        PlanetSurface planetSurface = new PlanetSurface(3, 3, false);
        planetSurface.addVehicle(3,3,Compass.NORTH);

        String returnMessage = planetSurface.selectedVehicle.move(planetSurface);

        assertEquals("", returnMessage);
        assertEquals(1, planetSurface.selectedVehicle.getX());
        assertEquals(2, planetSurface.selectedVehicle.getY());
    }
}