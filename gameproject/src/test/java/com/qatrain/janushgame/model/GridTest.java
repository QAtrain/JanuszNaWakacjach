package com.qatrain.janushgame.model;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;



/** Tests Grid methods. */
public class GridTest {

    @Ignore
    @Test
    public void verifyJanuszAndBeerDisplayedOnTheGrid() {


    }

    @Ignore
    @Test
    public void verifyAmountOfPaleczekInFirstAndLastLine() {
        Grid grid = new Grid();
        String printout = grid.drawTable();
        System.out.println(grid.drawTable());
        char toCheck = '|';
        int count = 0;

        for (int i = 0; i < printout.length(); i++) {
            if (printout.charAt(i) == toCheck) {
                count++;
            }
        }

        System.out.println(count);

       int rows = grid.rows;
       int columns = grid.columns;

       int total = rows*columns;

        assertEquals(total, count);
    }

    @Ignore
    @Test
    public void verifyAmountOfKreseczkiInSecondLineAndOneBeforeLast() {

    }

    @Ignore
    @Test
    public void verifyAmountOfRowsDisplayed() {

    }

    @Ignore
    @Test
    public void verifyAmountOfColumnsDisplayed() {

    }

    //TODO add more worthy tests!
}
