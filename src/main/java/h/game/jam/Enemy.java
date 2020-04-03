package h.game.jam;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Enemy {
    int counter = 0;
    double radius;
    Color color;
    double positionX;
    double positionY;
    Group group;
    Scene scene;
    Circle circle = new Circle();

    public Enemy(double radius, Color color, double positionX, double positionY, Group group, Scene scene) {
        this.radius = radius;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
        this.group = group;
        this.scene = scene;
        paint();
    }

    public void eventOnMove() {
        this.scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                this.circle.setCenterY(this.circle.getCenterY()+1);
            }
        });
        /**this.scene.setOnMouseMoved((EventHandler<MouseEvent>) mouseEvent -> {
            this.circle.setCenterY(this.circle.getCenterY()+1);
        });**/
    }

    public void eventOnClick() {
        this.circle.setOnMouseClicked((EventHandler<MouseEvent>) mouseEvent -> {
            refresh();
            counter++;
            System.out.println(counter);
        });
    }


    public void paint () {
        refresh();
        group.getChildren().add(this.circle);
    }

    public void refresh () {
        this.circle.setCenterX(this.positionX);
        this.circle.setCenterY(this.positionY);
        this.circle.setRadius(this.radius);
        this.circle.setFill(this.color);
    }

    public double getRadian() {
        return radius;
    }

    public void setRadian(double radius) {
        this.radius = radius;
        refresh();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        refresh();
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
        refresh();
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
        refresh();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group.getChildren().remove(this.circle);
        this.group = group;
        this.group.getChildren().add(this.circle);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
