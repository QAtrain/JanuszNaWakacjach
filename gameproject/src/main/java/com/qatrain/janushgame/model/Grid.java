package com.qatrain.janushgame.model;

/**
 * Grid resembles x / y grid on which Janusz and Beer are positioned.
 */
public class Grid {

    /** Minimal grid length. */
    static final int LENGTH_MIN = 4;
    /** Maximum grid's length */
    static final int LENGTH_MAX = 16;
    /** Minimal grid width. */
    static final int WIDTH_MIN = 4;
    /** Maximum grid's width */
    static final int WIDTH_MAX = 16;

    /** Grid's current length. */
    int length;
    /** Grid's current width. */
    int width;

    /** This method initializes grid. */
    void createGrid() {
        System.out.println("Creating grid...");


        int nought = 1;
        int cross = 2;

        int[][] elements = new int[3][3];
        elements[1][1] = nought;
        elements[2][2] = cross;
        elements[0][0] = nought;
        elements[1][2] = cross;
        elements[0][2] = nought;
        elements[0][1] = cross;

        System.out.print(elements);
    }

}