package application.logic;

import javafx.scene.input.KeyCode;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int x;
    private final int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public javafx.scene.input.KeyCode getOpposite() {
            switch (this) {
                case UP -> {
                    return KeyCode.DOWN;
                }
                case DOWN -> {
                    return KeyCode.UP;
                }
                case LEFT -> {
                    return KeyCode.RIGHT;
                }
                case RIGHT -> {
                    return KeyCode.LEFT;
                }
            }
            return null;
    }
}
