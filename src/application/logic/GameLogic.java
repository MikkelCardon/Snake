package application.logic;

import application.elements.Cell;
import application.elements.snake.Node;
import application.elements.snake.Snake;
import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.security.Key;
import java.util.Random;

public class GameLogic {

    public GameLogic() {
        new Snake();
        generateFood();
        startGame();
    }

    public static void startGame() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
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

        Node currentNode = Snake.getHead();
        Cell currentHeadCell = currentNode.getCell();
        Cell newCell = Controller.returnCellByCoordinates(currentHeadCell.getX()+ direction.getX(), currentHeadCell.getY()+ direction.getY());
        currentHeadCell.setHasSnake(false);

        currentNode.setCell(newCell);
        checkCollision(newCell);
        newCell.setHasSnake(true);
    }

    public static void checkCollision(Cell newCell){
        if(newCell.hasFood().getValue()){
            newCell.setHasFood(false);
            updateSnake(true, newCell);
            generateFood();
        }else if(newCell.isSnake()){
            System.out.println("Game Over");
            //ToDo implement game over
        }else{
            updateSnake(false, newCell);
        }
    }

    private static void updateSnake(boolean eatFood, Cell newCell){ {
        Node newNode = new Node(newCell);
        newNode.setNext(Snake.getHead());

        Snake.setHeadCell(newNode);
    }





    }

}
