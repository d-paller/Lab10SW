package lab10sw;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Lab10 extends Application{

    
    Circle circle = new Circle(50);
    
    Pane pane = new Pane();
    

    public void start(Stage primaryStage) {

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        
        BorderPane bPane = new BorderPane(hBox);
        BorderPane.setAlignment(hBox, Pos.BOTTOM_LEFT);
        
        circle.setCenterX(250);
        circle.setCenterY(250);

        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");

        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);

        btLeft.setOnMousePressed(e -> moveLeft());
        btRight.setOnMouseClicked(e -> moveRight());
        btUp.setOnMouseClicked(e -> moveUp());
        btDown.setOnMouseClicked(e -> moveDown());
        
        

        pane.getChildren().addAll(circle, bPane);
        
        

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        

    }//start
    
        public static void main(String[] args) {
        Application.launch(args);
    }//main
        
         public void moveUp() {
            if (circle.getCenterY() + circle.getRadius() -100 <= 0) {
            } else {
                circle.setCenterY(circle.getCenterY() - 20);
                System.out.println(circle.getCenterY() + circle.getRadius());
            }

        }//moveUp

        public void moveDown() {
            if (circle.getCenterY() + circle.getRadius() >= pane.getHeight()) {
            } else {
                circle.setCenterY(circle.getCenterY() + 20);
                System.out.println(circle.getCenterY() + circle.getRadius());
            }

        }//moveDown

        public void moveRight() {
            if (circle.getCenterX() + circle.getRadius() >= pane.getWidth()) {
            } else {
                circle.setCenterX(circle.getCenterX() + 20);
            }

        }//moveRight

        public void moveLeft() {
            if (circle.getCenterX() + circle.getRadius() -100 <= 0) {
            } else {
                circle.setCenterX(circle.getCenterX() - 20);
            }
        }//left
        
}//class
