/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author usu2dam
 */
public class InnerClass extends Application {
    private Circle circle = new Circle();
    @Override
    public void start(Stage primaryStage) {
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");
        
        BorderPane root = new BorderPane();
        StackPane circleRoot = new StackPane();
        
        circle.centerXProperty().bind(root.widthProperty().divide(2));
        circle.centerYProperty().bind(root.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        circleRoot.getChildren().add(circle);
        root.setCenter(circleRoot);
        
        HBox hBtn = new HBox(10);
        hBtn.setAlignment(Pos.CENTER);
        hBtn.setPadding(new Insets(15, 12, 15, 12));
        hBtn.getChildren().addAll(enlarge, shrink);
         
        enlarge.setOnAction(new Enlarger());
        shrink.setOnAction(new Shrinker());
        root.setBottom(hBtn);
                
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class Enlarger implements EventHandler<ActionEvent> {
      
            @Override
            public void handle(ActionEvent e) {
                circle.setRadius(circle.getRadius()+2);
            }
        } 
    class Shrinker implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            circle.setRadius(circle.getRadius()-2);
        }
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
