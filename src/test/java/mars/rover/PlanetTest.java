package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    @Test
    void planetTestName() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals("Mars", mars.getName());
    }

    @Test
    void planetTestDisstance() {
        Planet mars = new Planet("Mars", 227940000L);

        assertEquals(227940000L, mars.getDistanceFromSun());
    }
}