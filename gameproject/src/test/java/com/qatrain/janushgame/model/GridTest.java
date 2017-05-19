package com.qatrain.janushgame.model;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests Grid methods. */
public class GridTest {

    @Ignore
    @Test
    public void verifyJanuszAndBeerDisplayedOnTheGrid() {

    }

    @Ignore
    @Test
    public void verifyAmountOfPaleczekInFirstAndLastLine() {
        //Grid grid = new Grid();
        //String printout = grid.drawTable();
        //assert printout.contains("|"); //TODO this is dummy test
    }

    @Ignore
    @Test
    public void verifyAmountOfKreseczkiInSecondLineAndOneBeforeLast() {
        Grid grid = new Grid();
        grid.createGrid();

        String printout = grid.drawTable();
        System.out.println(grid.drawTable());

        int counter = printout.split("--", -1).length - 1;
//
        System.out.println(counter);

        int rows = grid.rows;
        int columns = grid.columns;

        int total = (rows-1)*columns;

        assertEquals(total, counter);
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
