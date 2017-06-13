package com.qatrain.janushgame.model;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;




/**
 * This tests checks if Janush moves on the grid as expected.
 */
public class JanuszTest {

    @Test
    public void janushMovesLeft() {

        Janush janusz = new Janush();
        janusz.positionX = 5;
        janusz.moveLeft();

        assertEquals("Janush moved left",
                4,janusz.positionX);


    }

    @Test
    public void janushMovesRight() {

        Janush janusz = new Janush();
        janusz.positionX = 5;
        janusz.moveRight();

        assertEquals("Janush moved right",
                6, janusz.positionX);


    }

    @Test
    public void janushMovesUp() {

        Janush janusz = new Janush();
        janusz.positionY = 4;
        janusz.moveUp();

        assertEquals("Janush moved left",
                5,janusz.positionY);


    }

    @Test
    public void janushMovesDown() {

        Janush janusz = new Janush();
        janusz.positionY = 4;
        janusz.moveDown();

        assertEquals("Janush moved left",
                3, janusz.positionY);


    }

    @Test
    public void janushMovesLeft_randomPosition() {
        Janush janusz = new Janush();

        //setting random minus position to catch more cases
        janusz.positionX = (int) (Math.random() * Integer.MIN_VALUE);
        int testPositionJanusz = janusz.positionX;

        System.out.println(janusz);
        janusz.moveLeft();

        assertEquals("Janush moved left from random position",
                testPositionJanusz - 1, janusz.positionX);

    }

    @Test
    public void janushMovesRight_randomPosition() {
        Janush janusz = new Janush();

        //setting random minus position to catch more cases
        janusz.positionX = (int) (Math.random() * Integer.MIN_VALUE);
        int testPositionJanusz = janusz.positionX;

        System.out.println(janusz);
        janusz.moveRight();

        assertEquals("Janush moved right from random position",
                testPositionJanusz + 1, janusz.positionX);

    }

    @Test
    public void janushMovesUp_randomPosition() {
        Janush janusz = new Janush();

        //setting random minus position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MIN_VALUE);
        int testPositionJanusz = janusz.positionY;

        System.out.println(janusz);
        janusz.moveUp();

        assertEquals("Janush moved up from random position",
                testPositionJanusz + 1, janusz.positionY);

    }

    @Test
    public void janushMovesDown_randomPosition() {
        Janush janusz = new Janush();

        //setting random minus position to catch more cases
        janusz.positionY = (int) (Math.random() * Integer.MIN_VALUE);
        int testPositionJanusz = janusz.positionY;

        System.out.println(janusz);
        janusz.moveDown();

        assertEquals("Janush moved down from random position",
                testPositionJanusz - 1, janusz.positionY);

    }
}



