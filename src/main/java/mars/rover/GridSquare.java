package mars.rover;

public class GridSquare extends GridReference {
    private final SurfaceType surfaceType;
    private final Integer altitude;

    public GridSquare(Integer x, Integer y) {
        super(x, y);
        surfaceType = SurfaceType.HARD;
        altitude = 0;
    }

    public GridSquare(Integer x, Integer y, SurfaceType surfaceType, Integer altitude) {
        super(x, y);
        this.surfaceType = surfaceType;
        this.altitude = altitude;
    }

    public SurfaceType getSurfaceType() {
        return surfaceType;
    }

    public String getSurfaceTypeName() {
        return surfaceType.getSurfaceName();
    }

    public Integer getAltitude() {
        return altitude;
    }
}
