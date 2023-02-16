package mars.rover;

public class Vehicle extends GridReference {
    private mars.rover.Heading heading;
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

    public Vehicle(Integer x, Integer y, Compass compass) {
        super(x, y);
        heading = new Heading(compass);
    }

    public void rotateLeft() {
        heading.rotateLeft();
    }

    public void rotateRight() {
        heading.rotateRight();
    }

    public Integer getHeading() {
        return heading.getHeading();
    }

    public String getHeadingName() {
        return heading.getHeadingName();
    }

    public String getHeadingLetter() {
        return heading.getHeadingLetter();
    }

    public String getLocation() {
        return getX().toString() + " " + getY() + " " + getHeadingLetter();
    }

    public Boolean canMove(GridSquare gridSquare) {
        return true; //TBC
    }

//    public GridReference newReference(Integer xMax, Integer yMax) {
//        super
//    }
}
