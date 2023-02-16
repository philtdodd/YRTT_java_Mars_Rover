package mars.rover;

public class PlanetSurface {
    private final Integer xSize;
    private final Integer ySize;

    private final Boolean globe;
    //TBC vehicle List
    //TBC selected vehicle
    private final GridSquare[][] surface;

    public PlanetSurface(Integer xSize, Integer ySize, Boolean globe) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.globe = globe;
        surface = new GridSquare[xSize + 1][ySize + 1];

        for (Integer x = 0; x <= xSize; x++)
            for (Integer y = 0; y <= ySize; y++)
                surface[x][y] = new GridSquare(x, y);
    }

    public Integer getXSize() {
        return xSize;
    }

    public Integer getYSize() {
        return ySize;
    }

    public Boolean getGlobe() {
        return globe;
    }

    public SurfaceType getSurfaceType(Integer x, Integer y) {
        return surface[x][y].getSurfaceType();
    }

    public SurfaceType getSurfaceType(GridReference gridReference) {
        return surface[gridReference.getX()][gridReference.getY()].getSurfaceType();
    }

    public String getSurfaceName(Integer x, Integer y) {
        return surface[x][y].getSurfaceTypeName();
    }

    public String getSurfaceName(GridReference gridReference) {
        return surface[gridReference.getX()][gridReference.getY()].getSurfaceTypeName();
    }
}
