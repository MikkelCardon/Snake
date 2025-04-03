package application.elements;

public class Board {
    private Cell[][] cells = new Cell[15][15];

    public Board() {
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                cells[x][y] = new Cell(x, y);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
