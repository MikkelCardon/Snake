package application.elements;

public class Board {
    private Cell[][] cells = new Cell[15][15];

    public Board() {
    }


    public Cell[][] getCellsAs2DArray() {
        return cells;
    }

    public Cell[] getCellAsArray() {
        Cell[] allCells = new Cell[15 * 15];

        int index = 0;
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                allCells[index++] = cell1;
            }
        }
        return allCells;
    }
}
