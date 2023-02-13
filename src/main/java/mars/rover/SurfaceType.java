package mars.rover;

enum SurfaceType {
    HARD,
    LIQUID,
    SAND,
    GRAVEL,
    ROCKS,
    BOULDERS;

    public String getSurfaceName() {
         return this.toString().toLowerCase();
    }
}
