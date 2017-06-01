package com.qatrain.janushgame.model;

/**
 * Class Janush describes an object which appears on grid and can change position.
 * His goal is to collect beer.
 * He gets 3 lives at the beginning.
 * When time is over Janush looses live.
 */
public class Janush extends Positioned {

    final static int LIVES_DEFAULT = 3;

    public Janush() {
        System.out.println("Creating Janush...");

        System.out.println("Created Janush.");
    }

    /**
     * Puts this janusz on grid's last row and column.
     * TODO randomize position
     * */
    public void putOnGrid(Grid grid) {
        positionX = grid.getWidth() - 1;
        positionY = grid.getHeight() - 1;
    }

    public void moveUp() {
        System.out.println(this + " moves         ^ UP ^");
        positionY--;
    }

    public void moveLeft() {
        System.out.println(this + " moves <<<<<<< LEFT");
        positionX--;
    }

    //TODO moveRight

    //TODO moveDown


    @Override
    public String toString() {
        return "Janush " + super.toString();
    }
}