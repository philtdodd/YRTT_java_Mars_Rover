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
                return "hard";
            case LIQUID:
                return "liquid";
            case SAND:
                return "sand";
            case GRAVEL:
                return "gravel";
            case ROCKS:
                return "rocks";
            case BOULDERS:
                return "boulders";
        }

        return "Error";
    }
}
