package mars.rover;

public class Heading implements Direction {
    Integer heading;
    public static final Integer NORTH = 0;
    public static final Integer EAST = 90;
    public static final Integer SOUTH = 180;
    public static final Integer WEST = 180;

    public Heading(Integer heading) {
        this.heading = heading;
    }

    @Override
    public Integer getHeading() {
        return heading;
    }

    public void rotateLeft() {
        if (heading != 0)
            heading -= 90;
        else
            heading = 270;
    }

    public void rotateRight() {
        if (heading != 270)
            heading += 90;
        else
            heading = 0;
    }
}