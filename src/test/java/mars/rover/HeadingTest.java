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

        assertEquals(Compass.NORTH.degrees, heading.getHeadingDegrees());
    }

    @Test
    void rotateLeftRound() {
        Heading heading = new Heading(Compass.NORTH);

        heading.rotateLeft();

        assertEquals(Compass.WEST.degrees, heading.getHeadingDegrees());
    }

    @Test
    void rotateRight() {
        Heading heading = new Heading(Compass.EAST);

        heading.rotateRight();

        assertEquals(Compass.SOUTH.degrees, heading.getHeadingDegrees());
    }

    @Test
    void rotateRightRound() {
        Heading heading = new Heading(Compass.WEST);

        heading.rotateRight();

        assertEquals(Compass.NORTH.degrees, heading.getHeadingDegrees());
    }

    @Test
    void testPeekMove00N() {
        Heading heading = new Heading(0, 0, Compass.NORTH);

        Heading peekedHeading = heading.peekMove(3, 3);
        assertEquals(0,peekedHeading.getX());
        assertEquals(1,peekedHeading.getY());
        assertEquals(Compass.NORTH,peekedHeading.getHeading());
    }

    @Test
    void testPeekMove00S() {
        Heading heading = new Heading(0, 0, Compass.SOUTH);

        Heading peekedHeading = heading.peekMove(3, 3);
        assertEquals(0,peekedHeading.getX());
        assertEquals(2,peekedHeading.getY());
        assertEquals(Compass.NORTH,peekedHeading.getHeading());
    }

    @Test
    void testPeekMove02S() {
        Heading heading = new Heading(0, 2, Compass.SOUTH);

        Heading peekedHeading = heading.peekMove(3, 3);
        assertEquals(0,peekedHeading.getX());
        assertEquals(1,peekedHeading.getY());
        assertEquals(Compass.SOUTH,peekedHeading.getHeading());
    }
}