package application.elements;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.shape.Box;

public class Cell {
    private int x, y;
    private SimpleBooleanProperty hasFood = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty isSnake = new SimpleBooleanProperty(false);
    private Box box;


    public Cell(int x, int y, Box box) {
        this.x = x;
        this.y = y;
        this.box = box;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SimpleBooleanProperty hasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood.set(hasFood);
    }

    public void setHasSnake(boolean hasSnake) {
        this.isSnake.set(hasSnake);
    }

    public boolean isSnake() {
        return isSnake.get();
    }

    public SimpleBooleanProperty isSnakeProperty() {
        return isSnake;
    }

    public Box getBox() {
        return box;
    }
}
