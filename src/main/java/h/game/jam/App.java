/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package h.game.jam;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import javafx.scene.input.MouseEvent;

public class App extends Application {

    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group,500,500, Color.DEEPSKYBLUE);
        {Rectangle ground = new Rectangle();
        ground.setWidth(500);
        ground.setHeight(100);
        ground.setY(475);
        ground.setFill(Color.GREEN);
        group.getChildren().add(ground);}
        {Rectangle character = new Rectangle();
        character.setFill(Color.BLACK);
        character.setHeight(50);
        character.setWidth(25);
        character.setX(250);
        character.setY(425);
        group.getChildren().add(character);}
        {Rectangle weapon = new Rectangle();
            int centerX = 500 / 2;
            int centerY = 500 / 2;
            scene.setOnMouseClicked((EventHandler< MouseEvent>) mouseEvent -> {
        double angle = Math.atan2(centerY - MouseInfo.getPointerInfo().getLocation().getY(), centerX - MouseInfo.getPointerInfo().getLocation().getX()) - Math.PI / 2;
        float degreesToMouse = (57.2957795f * (float)angle) * -1;
        weapon.setRotate(degreesToMouse);});
        weapon.setWidth(10);
        weapon.setHeight(40);
        weapon.setY(410);
        weapon.setX(258);
        weapon.setFill(Color.RED);
        group.getChildren().add(weapon);}
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game_Jam");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
