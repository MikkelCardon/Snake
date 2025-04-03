package application.logic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class KeyPressed {
    private static Direction direction = Direction.RIGHT;

    public static void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case UP -> direction = Direction.UP;
            case DOWN -> direction = Direction.DOWN;
            case LEFT -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.RIGHT;
            default -> {
                // Do nothing
            }
        }
    }
    public static Direction getDirection() {
        return direction;
    }
}
