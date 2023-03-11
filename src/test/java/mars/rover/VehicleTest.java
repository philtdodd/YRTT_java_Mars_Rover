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
    void movePlateau() {
        PlanetSurface planetSurface = new PlanetSurface(3, 3, false);
        planetSurface.addVehicle(3,3,Compass.NORTH);

        String returnMessage = planetSurface.selectedVehicle.move(planetSurface);

        assertEquals("ERROR: edge of surface\n", returnMessage);
        assertEquals(3, planetSurface.selectedVehicle.getX());
        assertEquals(3, planetSurface.selectedVehicle.getY());
    }

    @Test
    void moveGlobe() {
        PlanetSurface planetSurface = new PlanetSurface(3, 3, true);
        planetSurface.addVehicle(3,3,Compass.NORTH);

        String returnMessage = planetSurface.selectedVehicle.move(planetSurface);

        assertEquals("", returnMessage);
        assertEquals(3, planetSurface.selectedVehicle.getX());
        assertEquals(0, planetSurface.selectedVehicle.getY());
    }
}