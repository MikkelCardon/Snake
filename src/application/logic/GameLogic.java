package application.logic;

import application.elements.Cell;
import application.elements.snake.Node;
import application.elements.snake.Snake;
import controller.Controller;
import gui.MainWindow;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.Random;

public class GameLogic {
    private static Snake snake;
    private static boolean gameOver = false;

    public GameLogic() {
        snake = new Snake();
        generateFood();
        startGame();
    }

    public static void startGame() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), event -> {
            if (gameOver) {
                displayGameOver();
                return;
            }
            nextCell();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static void generateFood(){
        Random rand = new Random();
        Cell cell = Controller.returnCellByCoordinates(rand.nextInt(15), rand.nextInt(15));
        while(cell.isSnake()){
            cell = Controller.returnCellByCoordinates(rand.nextInt(15), rand.nextInt(15));
        }
        cell.setHasFood(true);
    }

    public static void nextCell(){
        Direction direction = KeyPressed.getDirection();

        Node currentNode = snake.getHead();
        Cell currentHeadCell = currentNode.getCell();

        if (outOfBounds(currentHeadCell, direction)){
            return;
        }

        Cell newCell = Controller.returnCellByCoordinates(currentHeadCell.getX()+ direction.getX(), currentHeadCell.getY()+ direction.getY());

        checkCollision(newCell);
    }

    private static boolean outOfBounds(Cell currentHeadCell, Direction direction) {
        int x = currentHeadCell.getX() + direction.getX();
        int y = currentHeadCell.getY() + direction.getY();

        if (x < 0 || x >= 15 || y < 0 || y >= 15) {
            System.out.println("Game Over");
            gameOver = true;
            return true;
        }
        return false;
    }

    public static void checkCollision(Cell newCell){
        if(newCell.hasFood().getValue()){
            newCell.setHasFood(false);
            updateSnake(true, newCell);
            generateFood();
        }else if(newCell.isSnake()){
            System.out.println("Game Over");
            gameOver = true;
        }else{
            updateSnake(false, newCell);
        }
    }

    private static void updateSnake(boolean eatFood, Cell newCell){
        Node newNode = new Node(newCell);
        newNode.setNext(snake.getHead());

        snake.setHeadCell(newNode);
        newCell.setHasSnake(true);

        if (!eatFood){
            Node previousNode = null;
            Node currentNode = snake.getHead();

            while(currentNode.getNext() != null){
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            currentNode.getCell().setHasSnake(false);
            previousNode.setNext(null);
        }
    }

    private static void displayGameOver(){
        Label label = new Label("Game Over");
        label.setStyle("-fx-font-size: 50px; -fx-text-fill: red;");
        MainWindow.getStackPane().getChildren().add(label);
    }

}
