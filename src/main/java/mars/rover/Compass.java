package mars.rover;

import com.sun.source.tree.ReturnTree;

import java.util.HashMap;
import java.util.Map;

public enum Compass {
    NORTH("N", "north", 0),
    EAST("E", "east", 90),
    SOUTH("S", "south", 180),
    WEST("W", "west", 270);

    private static final Map<String, Compass> LETTER = new HashMap();
    private static final Map<String, Compass> NAME = new HashMap();
    private static final Map<Integer, Compass> DEGREES = new HashMap();

    public final String letter;
    public final String name;
    public final Integer degrees;

    static {
        for (Compass point : values()) {
            LETTER.put(point.letter, point);
            NAME.put(point.name, point);
            DEGREES.put(point.degrees, point);
        }
    }

    Compass(String letter, String name, Integer degrees) {
        this.letter = letter;
        this.name = name;
        this.degrees = degrees;
    }

    public static Compass valueOfCompass(String point) {
        Compass compass = LETTER.get(point);

        if (compass == null) {
            compass = NAME.get(point.toLowerCase());
        }

        return compass;
    }

    public static Compass valueOfCompass(Integer degrees) {
        return DEGREES.get(degrees);
    }
}
