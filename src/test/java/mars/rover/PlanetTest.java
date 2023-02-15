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

        assertEquals("Error for command not Surface", mars.receivedCommand(" AS "));
    }

    @Test
    void GetSendValidSurfaceCommand() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Surface Initialized", mars.receivedCommand(" 123 123"));
        assertEquals(123, mars.planetSurface.getXSize());
        assertEquals(123, mars.planetSurface.getYSize());
    }
}