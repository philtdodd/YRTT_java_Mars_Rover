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
}
