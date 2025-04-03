package gui;

import application.elements.Board;
import application.elements.Cell;
import application.logic.GameLogic;
import application.logic.KeyPressed;
import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;


public class MainWindow extends Application {
    private Board board;
    
    @Override
    public void start(Stage stage) throws Exception {
        board = Controller.createNewGame();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        initlayout(gridPane);
        scene.setOnKeyPressed(KeyPressed::keyPressed);

        stage.setScene(scene);
        stage.show();
        stage.setTitle("Snake Game");

        GameLogic gameLogic = new GameLogic();
    }

    private void initlayout(GridPane gridPane) {
        int count = 0;

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Box box = new Box();
                box.setHeight(50);
                box.setWidth(50);
                box.setStyle("-fx-border-color: black; -fx-border-width: 1;");
                PhongMaterial color = new PhongMaterial(count++ % 2 == 0 ? Color.MEDIUMSEAGREEN : Color.LIGHTGREEN);
                box.setMaterial(color);
                box.setUserData(color);
                gridPane.add(box,x,y);

                Cell cell = new Cell(x, y, box);
                board.getCellsAs2DArray()[x][y] = cell;
                setChangeListener(cell);
            }
        }
    }

    private void setChangeListener(Cell cell) {
        cell.isSnakeProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                cell.getBox().setMaterial(new PhongMaterial(Color.PINK));
            } else {
                cell.getBox().setMaterial((PhongMaterial) cell.getBox().getUserData());
            }
        });

        cell.hasFood().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                cell.getBox().setMaterial(new PhongMaterial(Color.RED));
            } else {
                cell.getBox().setMaterial((PhongMaterial) cell.getBox().getUserData());
            }
        });
    }
}
