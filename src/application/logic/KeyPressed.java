package application.logic;


import javafx.scene.input.KeyEvent;


public class KeyPressed {
    private static Direction direction = Direction.RIGHT;

    public static void keyPressed(KeyEvent event) {
        if (direction.getOpposite() == event.getCode()) return; // Prevent moving in the opposite direction

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
