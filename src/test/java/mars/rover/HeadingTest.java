package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadingTest {

    @Test
    void getHeading() {
        Heading heading = new Heading(90);

        assertEquals(Heading.EAST, heading.getHeading());
    }

    @Test
    void rotateLeft() {
        Heading heading = new Heading(90);

        heading.rotateLeft();

        assertEquals(Heading.NORTH, heading.getHeading());
    }

    @Test
    void rotateLeftRound() {
        Heading heading = new Heading(0);

        heading.rotateLeft();

        assertEquals(Heading.WEST, heading.getHeading());
    }

    @Test
    void rotateRight() {
        Heading heading = new Heading(90);

        heading.rotateRight();

        assertEquals(Heading.SOUTH, heading.getHeading());
    }

    @Test
    void rotateRightRound() {
        Heading heading = new Heading(270);

        heading.rotateRight();

        assertEquals(Heading.NORTH, heading.getHeading());
    }
}