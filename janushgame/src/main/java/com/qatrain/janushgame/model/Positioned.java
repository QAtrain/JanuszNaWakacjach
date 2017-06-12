package com.qatrain.janushgame.model;

/**
 * An object that can be positioned on 2D surface.
 */
public abstract class Positioned {
    protected int positionX = 0;
    protected int positionY = 0;

    /**
     * Places this object inside board's frames.
     * @param board to be used for dimensions
     * */
    public abstract void putOnGrid(Board board);

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
     * It works both ways <code>object1.isOn(object2)</code> should always return the same as <code>object2.isOn(object1)</code>.
     *
     * @param positionedObject object to compare position to
     * @return true if this object is placed at the same position as the other <code>positionedObject</code>. */
    public boolean isOn(Positioned positionedObject) {
        return positionX == positionedObject.positionX &&
                positionY == positionedObject.positionY;
    }

    public boolean isOverboard(Board board) {
        return !(positionX >=0 &&
                positionX < board.getWidth() &&
                positionY >= 0 &&
                positionY < board.getHeight());
    }

    @Override
    public String toString() {
        return "(" + positionX + ", " + positionY + ")";
    }
}
