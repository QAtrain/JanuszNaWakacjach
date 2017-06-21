package com.qatrain.janushgame.model;

/**
 * Class Janush describes an object which appears on board and can change position.
 * His goal is to collect beer.
 * He gets 3 lives at the beginning.
 * When time is over Janush looses live.
 */
public class Janush extends Positioned {

    public final static int LIFES_DEFAULT = 3;

    public Janush() {
        System.out.println("Creating Janush...");

        System.out.println("Created Janush.");
    }

    /**
     * Puts this janusz on board's last row and column.
     * TODO randomize position
     * */
    public void putOnGrid(Board board) {
        positionX = board.getWidth() - 1;
        positionY = board.getHeight() - 1;
    }

    public void moveUp() {
        System.out.print(this + " moves     ^ UPUP ^");
        positionY--;
        System.out.println(" > " + super.toString());
    }

    public void moveLeft() {
        System.out.print(this + " moves     <<<<<<< LEFT");
        positionX--;
        System.out.println(" > " + super.toString());
    }

    public void moveRight() {
        System.out.print(this + " moves     RIGHT >>>>>>>>>>>");
        positionX++;
        System.out.println(" > " + super.toString());
    }

    public void moveDown() {
        System.out.print(this + " moves     v down v");
        positionY++;
        System.out.println(" > " + super.toString());
    }

    @Override
    public String toString() {
        return "Janush " + super.toString();
    }
}