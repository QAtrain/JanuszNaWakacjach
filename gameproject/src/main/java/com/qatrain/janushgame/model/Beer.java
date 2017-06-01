package com.qatrain.janushgame.model;

import java.util.Observable;
import java.util.Observer;

/**
 * Beer is an object placed on grid. Beer position during one level is constant.
 */
public class Beer extends Positionable {

    public Beer() {
        System.out.println("Creating beer...");
        System.out.println("Beer created.");
    }

    /**
     * Puts this beer at first row and column.
     *
     * TODO randomize position
     * */
    public void putOnGrid(Grid grid) {
        positionX = 0;
        positionY = 0;
    }
}