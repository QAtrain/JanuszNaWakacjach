package com.qatrain.janushgame.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for Janush movement on the grid.
 */
public class JanushTest {

    @Test
    public void janushMoveLeft() {
        Janush janusz = new Janush();

        janusz.positionX = 5;

        janusz.moveLeft();
        System.out.println(janusz);

        assertEquals("Janusz moved left", 4, janusz.positionX);


    }

    @Test
    public void janushMoveRight() {
        Janush janusz = new Janush();

        janusz.positionX = 5;

        janusz.moveRight();
        System.out.println(janusz);

        assertEquals("Janusz moved right", 6, janusz.positionX);


    }

    @Test
    public void janushMoveUp() {
        Janush janusz = new Janush();

        janusz.positionY = 5;

        janusz.moveUp();
        System.out.println(janusz);

        assertEquals("Janusz moved up", 4, janusz.positionY);


    }

    @Test
    public void janushMoveDown() {
        Janush janusz = new Janush();

        janusz.positionY = 5;

        janusz.moveDown();
        System.out.println(janusz);

        assertEquals("Janusz moved down", 6, janusz.positionY);


    }

    @Test
    public void janushMoveLeftRandomPosition() {
        Janush janusz = new Janush();

        //setting random position to catch more cases

        janusz.positionX = (int) (Math.random() * Integer.MAX_VALUE);
        int januszStartPosition = janusz.positionX;

        janusz.moveLeft();

        System.out.println(janusz);
        System.out.println(januszStartPosition);

        assertEquals("Janusz moved left from random position", januszStartPosition - 1, janusz.positionX);

    }

    @Test
    public void janushMoveRightRandomPosition() {
        Janush janusz = new Janush();

        //setting random position to catch more cases

        janusz.positionX = (int) (Math.random() * Integer.MAX_VALUE);
        int januszStartPosition = janusz.positionX;

        janusz.moveRight();

        System.out.println(janusz);
        System.out.println(januszStartPosition);

        assertEquals("Janusz moved right from random position", januszStartPosition + 1, janusz.positionX);

    }

    @Test
    public void janushMoveUpRandomPosition() {
        Janush janusz = new Janush();

        //setting random position to catch more cases

        janusz.positionY = (int) (Math.random() * Integer.MAX_VALUE);
        int januszStartPosition = janusz.positionY;

        janusz.moveUp();

        System.out.println(janusz);
        System.out.println(januszStartPosition);

        assertEquals("Janusz moved up from random position", januszStartPosition - 1, janusz.positionY);



    }

    @Test
    public void janushMoveDownRandomPosition() {
        Janush janusz = new Janush();

        //setting random position to catch more cases

        janusz.positionY = (int) (Math.random() * Integer.MAX_VALUE);
        int januszStartPosition = janusz.positionY;

        janusz.moveDown();

        System.out.println(janusz);
        System.out.println(januszStartPosition);

        assertEquals("Janusz moved down from random position", januszStartPosition + 1, janusz.positionY);



    }

}
