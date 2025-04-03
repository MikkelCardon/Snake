package gui;

import application.elements.Board;
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
    }

    private void initlayout(GridPane gridPane) {
        int count = 0;
        Box[] boxes = new Box[15 * 15];

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Box box = new Box();
                box.setHeight(50);
                box.setWidth(50);
                box.setStyle("-fx-border-color: black; -fx-border-width: 1;");
                box.setMaterial(new PhongMaterial(count % 2 == 0 ? Color.MEDIUMSEAGREEN : Color.LIGHTGREEN));
                gridPane.add(box,x,y);

                box.setUserData(Controller.returnCellByCoordinates(x, y));
                boxes[count++] = box;
            }
        }
        Controller.setBoxes(boxes);
    }
}
