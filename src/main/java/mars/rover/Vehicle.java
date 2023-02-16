package mars.rover;

public class Vehicle extends Heading {
    Integer xMax;
    Integer yMax;
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

    public Vehicle(Integer x, Integer y, Compass compass, Integer xMax, Integer yMax) {
        super(x, y, compass);
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public String getLocation() {
        return getX().toString() + " " + getY() + " " + getHeadingLetter();
    }

    public Boolean canMove(GridSquare gridSquare) {
        return true; //TBC Check climb rate against altitude, check surface against compatible surfaces.
    }

    public GridReference move() {
        Heading newLocation = peekMove(xMax, yMax);

        setX(newLocation.getX());
        setY(newLocation.getY());
        setHeading(newLocation.getHeading());

        return newLocation;
    }
}
