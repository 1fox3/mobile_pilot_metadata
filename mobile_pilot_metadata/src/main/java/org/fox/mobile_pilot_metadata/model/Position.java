package org.fox.mobile_pilot_metadata.model;

/**
 * Pure-data {@code x, y} coordinate carrier used by the ReactFlow editor.
 * Stored as raw {@code Number} so the position can be a pixel int or a
 * fraction without forcing the model to decide.
 */
public class Position {

    private Number x;
    private Number y;

    public Position() {
    }

    public Position(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public Number getX() {
        return x;
    }

    public void setX(Number x) {
        this.x = x;
    }

    public Number getY() {
        return y;
    }

    public void setY(Number y) {
        this.y = y;
    }
}
