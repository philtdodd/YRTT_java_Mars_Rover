package mars.rover;

enum SurfaceType {
    HARD,
    LIQUID,
    SAND,
    GRAVEL,
    ROCKS,
    BOULDERS;

    public String getSurface() {
        switch (this) {
            case HARD:
                return "Hard";
            case LIQUID:
                return "Liquid";
            case SAND:
                return "Sand";
            case GRAVEL:
                return "Gravel";
            case ROCKS:
                return "Rocks";
            case BOULDERS:
                return "Boulders";
        }
    }
}
