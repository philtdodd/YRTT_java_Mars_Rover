package mars.rover;

import java.util.ArrayList;

public class PlanetSurface {
    private final Integer xSize;
    private final Integer ySize;
    private final Boolean globe;

    private Integer lastVehicleId;
    private final ArrayList<Vehicle> vehicleList;
    public Vehicle selectedVehicle;

    private final GridSquare[][] surface;

    public PlanetSurface(Integer xSize, Integer ySize, Boolean globe) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.globe = globe;
        surface = new GridSquare[xSize + 1][ySize + 1];
        lastVehicleId = 0;
        vehicleList = new ArrayList<>();

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

    public String addVehicle(Integer x, Integer y, Compass h) {
        // check new cell is free
        for (Vehicle vehicle : vehicleList)
            if (vehicle.getX().equals(x) && vehicle.getY().equals(y))
                return "ERROR: Grid square occupied landing aborted.";

        // add vehicle
        lastVehicleId++;
        selectedVehicle = new Vehicle(x, y, h, xSize, ySize, globe, lastVehicleId);
        vehicleList.add(selectedVehicle);

        return "V" + lastVehicleId.toString();
    }

    public String selectVehicle(Integer id) {
        // check new cell is free
        for (Vehicle vehicle : vehicleList)
            if (vehicle.getId().equals(id)) {
                selectedVehicle = vehicle;
                return "Vehicle " + id + " Selected";
            }
        return "ERROR: Invalid vehicle id.";
    }

    public Integer isOccupied(Integer x, Integer y) {
        for (Vehicle vehicle : vehicleList)
            if (vehicle.getX().equals(x) && vehicle.getY().equals(y))
                return vehicle.getId();

        return -1;
    }
}