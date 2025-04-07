package controller;

import application.elements.Board;
import application.elements.Cell;
import application.elements.snake.Snake;


public class Controller {
    private static Board board;
    private static Snake snake;

    public static Board createNewGame(){
        board = new Board();
        return board;
    }

    public static Cell returnCellByCoordinates(int x, int y){
        return board.getCellsAs2DArray()[x][y];
    }


    /* SNAKE CONTROLLER*/
    public static void createSnake() {
        snake = new Snake();
    }


}
