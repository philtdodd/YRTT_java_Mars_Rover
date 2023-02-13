package mars.rover;

public class Planet {
    private final String name;
    private final Long distanceFromSun;
    private Integer[][] planetSurface;

    public Planet(String name, Long distanceFromSun) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
    }

    public String getName() {
        return name;
    }

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }
}
