package mars.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @ParameterizedTest
    @EnumSource(value = Compass.class)
    void valueOfCompass(Compass compass) {
        String expectedLetter;
        String expectedName;
        Integer expectedDegrees;

        switch (compass) {
            case NORTH:
                expectedLetter = "N";
                expectedName = "north";
                expectedDegrees = 0;
                break;
            case EAST:
                expectedLetter = "E";
                expectedName = "east";
                expectedDegrees = 90;
                break;
            case SOUTH:
                expectedLetter = "S";
                expectedName = "south";
                expectedDegrees = 180;
                break;
            case WEST:
                expectedLetter = "W";
                expectedName = "west";
                expectedDegrees = 270;
                break;
            default:
                expectedLetter = "ERROR";
                expectedName = "ERROR";
                expectedDegrees = -1;
                break;
        }

        assertEquals(expectedLetter, compass.letter);
        assertEquals(expectedName, compass.name);
        assertEquals(expectedDegrees, compass.degrees);
    }

    @Test
    void testValueOfCompass() {
        assertEquals(Compass.NORTH, Compass.valueOfCompass("N"));
        assertEquals(Compass.NORTH, Compass.valueOfCompass("North"));
        assertEquals(Compass.NORTH, Compass.valueOfCompass(0));
    }

}