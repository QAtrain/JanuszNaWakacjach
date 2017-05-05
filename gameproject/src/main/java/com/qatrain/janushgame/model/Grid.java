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
        //TODO set length
        //TODO set width
        System.out.println("Grid created.");
    }

}