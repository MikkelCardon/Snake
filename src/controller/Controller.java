package controller;

import application.elements.Board;
import application.elements.Cell;
import javafx.scene.shape.Box;

public class Controller {
    private static Board board;
    private static Box[] boxes;

    public static Board createNewGame(){
        board = new Board();
        return board;
    }

    public static Cell returnCellByCoordinates(int x, int y){
        return board.getCells()[x][y];
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoxes(Box[] boxes) {
        this.boxes = boxes;
    }
    public static Box[] getBoxes() {
        return boxes;
    }
}
