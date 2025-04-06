package application.elements;

public class Board {
    private Cell[][] cells = new Cell[15][15];

    public Board() {
    }


    public Cell[][] getCellsAs2DArray() {
        return cells;
    }


}
