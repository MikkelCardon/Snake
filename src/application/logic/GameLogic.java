package application.logic;

import application.elements.Cell;
import application.elements.snake.Snake;
import controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.Random;

public class GameLogic {

    public GameLogic() {
        new Snake();
        generateFood();
        startGame();
    }

    public static void startGame() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            KeyPressed.nextCell();
            //UpdateVisuals.updateCells();
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

}
