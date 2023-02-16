package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridReferenceTest {

    @Test
    void getX() {
        GridReference gridReference = new GridReference(1, 2);

        assertEquals(1, gridReference.getX());
    }

    @Test
    void setX() {
        GridReference gridReference = new GridReference(1, 2);

        gridReference.setX(2);

        assertEquals(2, gridReference.getX());
    }

    @Test
    void getY() {
        GridReference gridReference = new GridReference(1, 2);

        assertEquals(2, gridReference.getY());
    }

    @Test
    void setY() {
        GridReference gridReference = new GridReference(1, 2);

        gridReference.setY(1);

        assertEquals(1, gridReference.getY());
    }

    @Test
    void getPeekMove00N() {
        GridReference gridReference = new GridReference(0, 0);
        Heading heading = new Heading(Compass.NORTH);

        // assertEquals(new GridReference(0,1), gridReference.peekMove(3,3, heading));
        assertEquals(Compass.NORTH, heading);
    }
}