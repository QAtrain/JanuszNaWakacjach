package com.qatrain.janushgame.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by gumkowsk on 07-Jun-17.
 */
public class MovesTest {

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
