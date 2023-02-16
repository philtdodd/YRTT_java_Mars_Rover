package mars.rover;

enum CapabilityType {
    DRILL,
    COLLECTOR,
    SPECTROMETER,
    ARM,
    CAMERANIGHTVISION,
    CAMERAINFRARED,
    CAMERAVISIBLELIGHT,
    CAMERABLAKCANDWHITE;

    public String getCapabilityName() {
        switch (this) {
            case DRILL:
                return "drill";
            case COLLECTOR:
                return "collector";
            case SPECTROMETER:
                return "spectrometer";
            case ARM:
                return "arm";
            case CAMERANIGHTVISION:
                return "night vision camera";
            case CAMERAINFRARED:
                return "infrared camera";
            case CAMERAVISIBLELIGHT:
                return "visible light camera";
            case CAMERABLAKCANDWHITE:
                return "bland and white camera";
        }

        return "ERROR";
    }
}
