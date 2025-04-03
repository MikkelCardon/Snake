package application.logic;

import application.elements.Cell;
import application.elements.snake.Node;
import application.elements.snake.Snake;
import controller.Controller;
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

    public static void nextCell(){
        Node currentNode = Snake.getHead();
        Cell currentHeadCell = currentNode.getCell();
        Cell newCell = Controller.returnCellByCoordinates(currentHeadCell.getX()+ direction.getX(), currentHeadCell.getY()+ direction.getY());
        currentHeadCell.setHasSnake(false);

        currentNode.setCell(newCell);
        newCell.setHasSnake(true);
    }

    public static Direction getDirection() {
        return direction;
    }
}
