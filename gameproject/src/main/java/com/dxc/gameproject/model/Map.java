package com.dxc.gameproject.model;

/**
 * Map resembles x / y grid on which Janusz and Beer are positioned.
 */
public class Map {

    /** Minimal grid length. */
    static final int LENGTH_MIN = 4;
    /** Maximum grid's length */
    static final int LENGTH_MAX = 16;
    /** Minimal grid width. */
    static final int WIDTH_MIN = 4;
    /** Maximum grid's width */
    static final int WIDTH_MAX = 16;

    /** Map's current length. */
    int length;
    /** Map's current width. */
    int width;

    /** This method initializes map. */
    void createMap() {
        System.out.println("Creating map...");
        //TODO set length
        //TODO set width
        System.out.println("Map created.");
    }

}
