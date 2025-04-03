package application.logic;

import application.elements.Cell;
import application.elements.snake.Node;
import controller.Controller;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class UpdateVisuals {

    public static void updateCells(){
        Node currentNode = Controller.getSnakeHead();
        while (currentNode != null) {
            currentNode.getCell().setHasSnake(true);
            currentNode = currentNode.getNext();
        }

        for (Cell cell : Controller.getBoard().getCellAsArray()) {
            Box box = cell.getBox();
            if (cell.isSnake()){
                box.setMaterial(new PhongMaterial(Color.PINK));
            }else {
                PhongMaterial color = (PhongMaterial) box.getUserData();
                box.setMaterial(color);
            }
        }
    }
}
