package application.elements.snake;

import application.elements.Cell;
import controller.Controller;

public class Snake {
    private static Node head;
    private static Node tail;

    public Snake() {
        Node startNode = new Node(Controller.returnCellByCoordinates(7, 7));
        this.head = null;
        this.tail = null;
    }

    public void setHeadCell(Cell cell) {
        this.head.setCell(cell);
    }

    public static Node getHead() {
        return head;
    }
}
