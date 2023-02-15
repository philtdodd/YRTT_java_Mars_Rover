package mars.rover;

public class PlanetSurface {
    private Integer xSize;
    private Integer ySize;
    //TBC vehicle List
    //TBC selected vehicle
    private GridSquare[][] surface;

    public PlanetSurface(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        surface = new GridSquare[xSize][ySize];

        for (Integer x = 0; x < xSize; x++)
            for (Integer y = 0; y < ySize; y++)
                surface[x][y] = new GridSquare(x, y);
    }

    public Integer getXSize() {
        return xSize;
    }

    public Integer getYSize() {
        return ySize;
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
