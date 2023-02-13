package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTypeTest {

    @Test
    void getSurfaceHard() {
        SurfaceType surface = SurfaceType.HARD;

        assertEquals("hard", surface.getSurface());
    }
}