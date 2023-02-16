package mars.rover;

public class Heading extends GridReference {
    private Compass heading;

    public Heading(Compass heading) {
        this.heading = heading;
        super.setX(0);
        super.setY(0);
    }

    public Heading(Integer x, Integer y, Compass heading) {
        super(x, y);
        this.heading = heading;
    }

    public Integer getHeading() {
        return heading.degrees;
    }

    public void rotateLeft() {
        if (heading.degrees != 0)
            heading = Compass.valueOfCompass(heading.degrees - 90);
        else
            heading = Compass.WEST;
    }

    public void rotateRight() {
        if (heading.degrees != 270)
            heading = Compass.valueOfCompass(heading.degrees + 90);
        else
            heading = Compass.NORTH;
    }

    public String getHeadingName() {
        return heading.name;
    }

    public String getHeadingLetter() {
        return heading.letter;

    }

    protected Heading peekMove(Integer xMax, Integer yMax) {
        Integer newX = getX();
        Integer newY = getY();
        Compass newHeading = heading;

        if (heading == Compass.NORTH)
            newY++;
        else if (heading == Compass.EAST)
            newX++;
        else if (heading == Compass.SOUTH)
            newY--;
        else if (heading == Compass.WEST)
            newX--;
        else
            return (new Heading(getX(), getY(), heading));

        if (newX == -1)
            newX = xMax;
        else if (newX == xMax)
            newX = 0;

        if (newY == -1) {
            newY = yMax;
            newHeading = Compass.NORTH;
        } else if (newY == yMax) {
            newY = 0;
            newHeading = Compass.SOUTH;
        }

        return (new Heading(newX, newY, newHeading));
    }
}