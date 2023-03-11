package mars.rover;

public class Vehicle extends Heading {
    Integer id;
    Integer xMax;
    Integer yMax;
    Boolean globe;
    //TBC transverses a list of SurfaceType
    //TBC Integer climbRate;
    //TBC capabilities a list of Capability
    //TBC arms List
    //TBC cameras List
    //TBC drills List
    //TBC collectors List
    //TBC spectrometers List
    //TBC selected capability
    //TBC selected arm
    //TBC selected camera
    //TBC selected drill
    //TBC selected collector
    //TBC selected spectrometer

    public Vehicle(Integer x, Integer y, Compass compass, Integer xMax, Integer yMax, Boolean globe, Integer id) {
        super(x, y, compass);
        this.xMax = xMax;
        this.yMax = yMax;
        this.globe = globe;
        this.id = id;
    }

    public String getLocation() {
        return getX().toString() + " " + getY() + " " + getHeadingLetter();
    }

    public Integer getId() {
        return id;
    }

    public Boolean canMove(GridSquare gridSquare) {
        return true; //TBC Check climb rate against altitude, check surface against compatible surfaces.
    }

    public String move(PlanetSurface planetSurface) {
        Heading newLocation;

        try {
            newLocation = peekMove(xMax, yMax, globe);
        } catch (Exception e) {
            return "ERROR: edge of surface";
        }

        Integer occupied = planetSurface.isOccupied(newLocation.getX(), newLocation.getY());
        if (occupied != -1)
            return "ERROR: grid reference occupied\n";

        setX(newLocation.getX());
        setY(newLocation.getY());
        setHeading(newLocation.getHeading());

        return "";
    }
}
