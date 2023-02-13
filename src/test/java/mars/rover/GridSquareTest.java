package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridSquareTest {
    @Test
    void getSurfaceTypeTestDefault() {
        GridSquare gridSquare = new GridSquare(1,2);

        assertEquals(SurfaceType.HARD, gridSquare.getSurfaceType());
    }

    @Test
    void getSurfaceTypeFullConstructor() {
        GridSquare gridSquare = new GridSquare(1,2, SurfaceType.SAND, 100);

        assertEquals(SurfaceType.SAND, gridSquare.getSurfaceType());
    }

    @Test
    void getSurfaceTypeName() {
        GridSquare gridSquare = new GridSquare(1,2);

        assertEquals("hard", gridSquare.getSurfaceTypeName());
    }

    @Test
    void getAltitudeDefaultConstructor() {
        GridSquare gridSquare = new GridSquare(1,2);

        assertEquals(0, gridSquare.getAltitude());
    }

    @Test
    void getAltitudeFullConstructor() {
        GridSquare gridSquare = new GridSquare(1,2, SurfaceType.GRAVEL, 100);

        assertEquals(100, gridSquare.getAltitude());
    }
}