package com.qatrain.janushgame.model;

/**
 * An object that can be positioned on 2D surface.
 */
public abstract class Positionable {
    protected int positionX = 0;
    protected int positionY = 0;

    /**
     * Places this object inside grid's frames.
     * @param grid to be used for dimensions
     * */
    public abstract void putOnGrid(Grid grid);

    /** @return this object's position on X axis */
    public int getPositionX() {
        return positionX;
    }

    /** @return this object's position on Y axis */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Checks whether this object is placed at the same position as another object.
     *
     * @return true if this object is placed at the same position as the other <code>positionableObject</code>. */
    public boolean isOn(Positionable positionableObject) {
        return positionX == positionableObject.positionX &&
                positionY == positionableObject.positionY;
    }

    @Override
    public String toString() {
        return "(" + positionX + ", " + positionY + ")";
    }
}
