package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadingTest {

    @Test
    void getHeading() {
        Heading heading = new Heading(Compass.NORTH);

        assertEquals("north", heading.getHeadingName());
    }

    @Test
    void getHeadingName() {
        Heading heading = new Heading(Compass.SOUTH);

        assertEquals("south", heading.getHeadingName());
    }

    @Test
    void getHeadingLetter() {
        Heading heading = new Heading(Compass.WEST);

        assertEquals("W", heading.getHeadingLetter());
    }

    @Test
    void rotateLeft() {
        Heading heading = new Heading(Compass.EAST);

        heading.rotateLeft();

        assertEquals(Compass.NORTH, heading.getHeading());
    }

    @Test
    void rotateLeftRound() {
        Heading heading = new Heading(Compass.NORTH);

        heading.rotateLeft();

        assertEquals(Compass.WEST, heading.getHeading());
    }

    @Test
    void rotateRight() {
        Heading heading = new Heading(Compass.EAST);

        heading.rotateRight();

        assertEquals(Compass.SOUTH, heading.getHeading());
    }

    @Test
    void rotateRightRound() {
        Heading heading = new Heading(Compass.WEST);

        heading.rotateRight();

        assertEquals(Compass.NORTH, heading.getHeading());
    }
}