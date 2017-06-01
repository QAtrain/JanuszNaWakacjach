package com.qatrain.janushgame.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests Positionable object methods.
 */
public class PositionableTest {

    @Test
    public void testIsOn() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        janusz.positionY = (int) (Math.random() * Integer.MAX_VALUE); //TODO explain on training
        janusz.positionX = (int) (Math.random() * Integer.MAX_VALUE);
        beer.positionY = janusz.positionY;
        beer.positionX = janusz.positionX;

        System.out.println(janusz);
        System.out.println(beer);

        assertTrue("Janusz has same position as beer",
                janusz.isOn(beer));

        assertTrue("Beer has same position as janusz",
                janusz.isOn(beer));
    }

    @Test
    public void testIsNotOn() {
        Janush janusz = new Janush();
        Beer beer = new Beer();

        janusz.positionY = 4;
        janusz.positionX = 5;
        beer.positionY = (int) (Math.random() * janusz.positionX); //TODO explain on training
        beer.positionX = (int) (Math.random() * janusz.positionY);

        System.out.println(janusz);
        System.out.println(beer);

        assertFalse("Janusz does not have same position as beer",
                janusz.isOn(beer));

        assertFalse("Beer does not have same position as janusz",
                janusz.isOn(beer));
    }

}
