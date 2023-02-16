package mars.rover;

public class Heading implements Direction {
    Integer heading;
    public static final Integer NORTH = 0;
    public static final Integer EAST = 90;
    public static final Integer SOUTH = 180;
    public static final Integer WEST = 270;

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

    public String getHeadingName() {
        return switch (this.heading) {
            case 0 -> "north";
            case 90 -> "east";
            case 180 -> "south";
            case 270 -> "west";
            default -> "Error";
        };
    }

    public String getHeadingLetter() {
        return getHeadingName().toUpperCase().substring(0, 1);
    }
}