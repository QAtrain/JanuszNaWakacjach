package com.qatrain.janushgame.model;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;

/**
 * Tests Board methods.
 */
public class BoardTest {

    @Ignore
    @Test
    public void verifyJanuszAndBeerDisplayedOnTheGrid() {

    }

    @Ignore
    @Test
    public void verifyAmountOfPaleczekInFirstAndLastLine() {
        //Board board = new Board();
        //String printout = board.drawBoard();
        //assert printout.contains("|"); //TODO this is dummy test
    }

    @Ignore
    @Test
    public void verifyAmountOfKreseczkiInSecondLineAndOneBeforeLast() {

    }

    @Ignore
    @Test
    public void verifyAmountOfRowsDisplayed() {
        Board board = new Board();
        String displayedGrid = board.drawBoard();
        System.out.println("Table preview: " + "\n" + displayedGrid); //displaying comparable Board for preview
        System.out.println("Number of rows should be: " + board.getHeight()); //displaying number of rows got from algorithm

        //compare if "|" is drawing correctly and how many times "\n" is displaying. This method comes from common-lang3 maven dependency
        int rowsActuallyDisplayed = StringUtils.countMatches(displayedGrid, StringUtils.repeat(" |", board.getWidth()) + "\n");

        System.out.println("Number of rows found: " + rowsActuallyDisplayed);

        Assert.assertEquals(board.getHeight(), rowsActuallyDisplayed); //comparing number of rows got from algorithm and displayed rows
    }

    @Ignore
    @Test
    public void verifyAmountOfColumnsDisplayed() {

    }

    //TODO add more worthy tests!
}
