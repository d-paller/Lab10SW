package lab10sw;

import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.geometry.Point2D;
/**
 *
 * @author David
 */
public class AssignmentSix extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle1 = new Circle(10);
        circle1.setCenterX(40);
        circle1.setCenterY(40);
        circle1.setFill(Color.BLUE);
        
        Circle circle2 = new Circle(10);
        circle2.setCenterX(120);
        circle2.setCenterY(150);
        circle2.setFill(Color.BROWN);
        
        String distance = new Point2D(circle1.getCenterX(), circle1.getCenterY()).distance(circle2.getCenterX(), 
                circle2.getCenterY()) + "";
        
        
        Line line = new Line(circle2.getCenterX(), circle2.getCenterY(), circle1.getCenterX(), circle1.getCenterY());
        
        Text text = new Text((line.getEndX() + line.getStartX())/2, (line.getStartY() + 
                line.getEndY())/2, distance);
        
        circle1.setOnMouseDragged(e -> {
            circle1.setCenterX(e.getX());
            circle1.setCenterY(e.getY());
            line.setEndY(circle1.getCenterY());
            line.setEndX(circle1.getCenterX());
            text.setX((line.getEndX() + line.getStartX())/2);
            text.setY((line.getStartY() + line.getEndY())/2);
            text.setText(new Point2D(circle1.getCenterX(), circle1.getCenterY()).distance(circle2.getCenterX(), 
                circle2.getCenterY()) + "");
            
            
        });
        
        
        
        circle2.setOnMouseDragged(e -> {
            
            
            
            circle2.setCenterX(e.getX());
            circle2.setCenterY(e.getY());
            line.setStartX(circle2.getCenterX());
            line.setStartY(circle2.getCenterY());
            text.setX((line.getEndX() + line.getStartX())/2);
            text.setY((line.getStartY() + line.getEndY())/2);
            text.setText(new Point2D(circle1.getCenterX(), circle1.getCenterY()).distance(circle2.getCenterX(), 
                circle2.getCenterY()) + "");
        
        });
        
        
        
        
        pane.getChildren().addAll(circle1, circle2, line, text);
        Scene scene = new Scene(pane, 600, 600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
