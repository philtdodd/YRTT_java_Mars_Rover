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
        return switch (this) {
            case DRILL -> "drill";
            case COLLECTOR -> "collector";
            case SPECTROMETER -> "spectrometer";
            case ARM -> "arm";
            case CAMERANIGHTVISION -> "night vision camera";
            case CAMERAINFRARED -> "infrared camera";
            case CAMERAVISIBLELIGHT -> "visible light camera";
            case CAMERABLAKCANDWHITE -> "black and white camera";
        };
    }
}
