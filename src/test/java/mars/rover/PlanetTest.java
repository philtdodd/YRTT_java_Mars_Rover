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

        assertEquals("Error no command", mars.receivedCommand(""));
    }

    @Test
    void GetSendNullCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Error no command", mars.receivedCommand(null));
    }

    @Test
    void GetSendInvalidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Error command not surface specification", mars.receivedCommand(" AS "));
    }

    @Test
    void GetSendInvalidThenValidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Error command not surface specification", mars.receivedCommand(" AS "));
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
        assertEquals("Error command not rover landing command", mars.receivedCommand(" 123 123 "));
    }

    @Test
    void GetSendValidLandRoverCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("", mars.receivedCommand(" 3 3"));
        assertEquals("", mars.receivedCommand(" 0 0 N"));
    }
}