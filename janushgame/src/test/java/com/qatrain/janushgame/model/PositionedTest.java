package com.qatrain.janushgame.model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Positioned object methods.
 */
public class PositionedTest {

    @Test
    public void isOnReturnsTrueWhenObjectsHaveSamePosition() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        //setting hardcoded values for readability
        janusz.positionY = 3;
        janusz.positionX = 4;
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                beer.isOn(janusz));
    }

    @Test
    public void isOnReturnsTrueWhenObjectsHaveSamePosition_randomPosition() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        //setting random position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MAX_VALUE);
        janusz.positionX = (int) (Math.random() * Integer.MAX_VALUE);
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                beer.isOn(janusz));
    }

    @Test
    public void isOnReturnsTrueWhenObjectsHaveSamePosition_randomPosition_xAndYOnMinusSide() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        //setting random minus position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MIN_VALUE);
        janusz.positionX = (int) (Math.random() * Integer.MIN_VALUE);
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                beer.isOn(janusz));
    }

    @Test
    //two cases in one test
    public void isOnReturnsTrueWhenObjectsHaveSamePosition_forRandomPosition_xAndYRandomlyMinusOrPlus_twoCasesInOne() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        //setting random minus and plus position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MIN_VALUE);
        janusz.positionX = (int) (Math.random() * Integer.MAX_VALUE);
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                beer.isOn(janusz));

        /////////////////////////////////////////////////////////////////////////

        //setting random minus and plus position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MAX_VALUE);
        janusz.positionX = (int) (Math.random() * Integer.MIN_VALUE);
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                beer.isOn(janusz));
    }

    @Test
    public void isOnReturnsFalseWhenObjectsHaveDifferentPosition() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        janusz.positionY = 4;
        janusz.positionX = 5;
        beer.positionY = 3;
        beer.positionX = 6;

        System.out.println(janusz);
        System.out.println(beer);

        assertFalse("Janusz does not have same position as beer",
                janusz.isOn(beer));

        assertFalse("Beer does not have same position as janusz",
                beer.isOn(janusz));
    }

    @Test
    public void isOnReturnsFalseWhenObjectsHaveDifferentPosition_randomPosition() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        //do not change both of these to negative numbers, because test will fail randomly!
        janusz.positionY = 4;
        janusz.positionX = 5;

        //random position from (0 - janusz.positionY)-1 will always yield different position than janusz's Y position (lower number)
        //unless someone changes janusz's positions above to negative numbers (with minus sign) - then this test will be WRONG
        beer.positionY = (int) (Math.random() * (janusz.positionY - 1));
        beer.positionX = (int) (Math.random() * (janusz.positionX - 1));

        System.out.println(janusz);
        System.out.println(beer);

        assertFalse("Janusz does not have same position as beer",
                janusz.isOn(beer));

        assertFalse("Beer does not have same position as janusz",
                beer.isOn(janusz));
    }
}
