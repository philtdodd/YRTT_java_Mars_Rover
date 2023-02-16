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
}