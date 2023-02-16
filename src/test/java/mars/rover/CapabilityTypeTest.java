package mars.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class CapabilityTypeTest {

    @ParameterizedTest
    @EnumSource(value = CapabilityType.class)
    void getCapabilityName(CapabilityType capability) {
        String expected;
        switch (capability) {
            case DRILL:
                expected = "drill";
                break;
            case COLLECTOR:
                expected = "collector";
                break;
            case SPECTROMETER:
                expected = "spectrometer";
                break;
            case ARM:
                expected = "arm";
                break;
            case CAMERANIGHTVISION:
                expected = "night vision camera";
                break;
            case CAMERAINFRARED:
                expected = "infrared camera";
                break;
            case CAMERAVISIBLELIGHT:
                expected = "visible light camera";
                break;
            case CAMERABLAKCANDWHITE:
                expected = "black and white camera";
                break;
            default:
                expected = "ERROR";
                break;
        }

        assertEquals(expected, capability.getCapabilityName());
    }
}