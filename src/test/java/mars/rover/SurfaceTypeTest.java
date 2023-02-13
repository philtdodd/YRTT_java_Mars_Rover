package mars.rover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class SurfaceTypeTest {

    @ParameterizedTest
    @EnumSource(value = SurfaceType.class)
    void getSurfaceHard(SurfaceType surface) {
        assertEquals(surface.toString().toLowerCase(), surface.getSurfaceName());
    }
}