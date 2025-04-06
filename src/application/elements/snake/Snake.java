package application.elements.snake;

import application.elements.Cell;
import controller.Controller;

public class Snake {
    private Node head;

    public Snake() {
        this.head = new Node(Controller.returnCellByCoordinates(7, 7));
    }

    public void setHeadCell(Node node) {
        this.head = node;
    }

    public Node getHead() {
        return head;
    }

}
