package mars.rover;

public class GridReference {
    private Integer x;
    private Integer y;

    public GridReference() {
        this.x = 0;
        this.y = 0;
    }

    public GridReference(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    protected void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    protected void setY(Integer y) {
        this.y = y;
    }

//    protected GridReference peekMove(Integer xMax, Integer yMax, Heading heading) {
//        Integer newX = x;
//        Integer newY = y;
//
//        if (heading.getHeading() == Heading.NORTH)
//            newY++;
//        else if (heading.getHeading() == Heading.EAST)
//            newX++;
//        else if (heading.getHeading() == Heading.SOUTH)
//            newY--;
//        else if (heading.getHeading() == Heading.WEST)
//            newX--;
//        else
//            return (new GridReference(x, y));
//
//        if (newX == -1)
//            newX = xMax;
//        else if (newX == xMax)
//            newX = 0;
//
//        if (newY == -1) {
//            newY = yMax;
//            heading.rotateLeft();
//            heading.rotateLeft();
//        } else if (newY == yMax) {
//            newY = 0;
//            heading.rotateLeft();
//            heading.rotateLeft();
//        }
//
//        return (new GridReference(newX, newY));
//    }
}
