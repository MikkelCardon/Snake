package application.elements;

import javafx.beans.property.SimpleBooleanProperty;

public class Cell {
    private int x, y;
    private boolean hasFood;
    private SimpleBooleanProperty isSnake = new SimpleBooleanProperty(false);

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean HasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public void setHasSnake(boolean hasSnake) {
        this.isSnake.set(hasSnake);
    }
}
