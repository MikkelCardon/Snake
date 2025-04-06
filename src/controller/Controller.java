package controller;

import application.elements.Board;
import application.elements.Cell;
import application.elements.snake.Node;
import application.elements.snake.Snake;
import javafx.scene.shape.Box;

public class Controller {
    private static Board board;
    private static Box[] boxes;
    private Snake snake;

    public static Board createNewGame(){
        board = new Board();
        return board;
    }

    public static Cell returnCellByCoordinates(int x, int y){
        return board.getCellsAs2DArray()[x][y];
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoxes(Box[] boxes) {
        Controller.boxes = boxes;
    }

    public static Box[] getBoxes() {
        return boxes;
    }

    public static Node getSnakeHead() {
        return Snake.getHead();
    }

}
