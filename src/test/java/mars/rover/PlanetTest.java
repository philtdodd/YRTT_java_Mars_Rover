package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    @Test
    void TestName() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Mars", mars.getName());
    }

    @Test
    void TestDisstance() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals(227940000L, mars.getDistanceFromSun());
    }

    @Test
    void GetSendEmptyCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("ERROR: no command", mars.receivedCommand(""));
    }

    @Test
    void GetSendNullCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("ERROR: no command", mars.receivedCommand(null));
    }

    @Test
    void GetSendInvalidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("ERROR: command not surface specification", mars.receivedCommand(" AS "));
    }

    @Test
    void GetSendInvalidThenValidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("ERROR: command not surface specification", mars.receivedCommand(" AS "));
        assertEquals("", mars.receivedCommand(" 3 3 "));
        assertEquals(3, mars.planetSurface.getXSize());
        assertEquals(3, mars.planetSurface.getYSize());
    }

    @Test
    void GetSendValidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("", mars.receivedCommand(" 123 123"));
        assertEquals(123, mars.planetSurface.getXSize());
        assertEquals(123, mars.planetSurface.getYSize());
    }

    @Test
    void GetSendInvalidLandRoverCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("", mars.receivedCommand(" 123 123"));
        assertEquals("ERROR: command not rover landing command", mars.receivedCommand(" 123 123 "));
    }

    @Test
    void GetSendValidLandRoverCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("", mars.receivedCommand(" 3 3"));
        assertEquals("", mars.receivedCommand(" 0 0 N"));
        assertEquals(0, mars.selectedVehicle.getX());
        assertEquals(0, mars.selectedVehicle.getY());
        assertEquals(Compass.NORTH, mars.selectedVehicle.getHeading());
    }
    @Test
    void GetSendExample1() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("", mars.receivedCommand("5 5"));
        assertEquals("", mars.receivedCommand("1 2 N"));
        assertEquals("1 3 N", mars.receivedCommand("LMLMLMLMM"));
        assertEquals(1, mars.selectedVehicle.getX());
        assertEquals(3, mars.selectedVehicle.getY());
        assertEquals(Compass.NORTH, mars.selectedVehicle.getHeading());
        assertEquals("", mars.receivedCommand("3 3 E"));
        assertEquals("5 1 E", mars.receivedCommand("MMRMMRMRRM"));
        assertEquals(5, mars.selectedVehicle.getX());
        assertEquals(1, mars.selectedVehicle.getY());
        assertEquals(Compass.EAST, mars.selectedVehicle.getHeading());
    }
}