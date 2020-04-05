package h.game.jam;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Enemy {
    int counter;
    double radius;
    double positionX;
    double positionY;
    Group group;
    Scene scene;
    Circle circle = new Circle();

    public Enemy(double radius, double positionX, double positionY, Group group, Scene scene, int counter) {
        this.radius = radius;
        this.positionX = positionX;
        this.positionY = positionY;
        this.group = group;
        this.scene = scene;
        this.counter = counter;
    }

    public void eventOnMove() {
        if(group.getChildren().contains(circle)) {
            this.scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                circle.setCenterY(circle.getCenterY()+1);
                if(circle.getCenterY() > 975 && group.getChildren().contains(circle)) {
                    App.counter -= counter *2;
                    refresh();
                }
            }
        });}
    }


    public void eventOnClick() {
        if(group.getChildren().contains(circle)) {
            this.circle.setOnMouseClicked((EventHandler<MouseEvent>) mouseEvent -> {
            App.counter += counter;
            group.getChildren().remove(circle);
        });}
    }

    public void setColor() {
        if(counter == 1){
            circle.setFill(Color.RED);
        }else if(counter == 2) {
            circle.setFill(Color.BLACK);
        }else if(counter > 2 && counter < 25) {
            circle.setFill(Color.PINK);
        }else if(counter > 24 && counter < 50) {
            circle.setFill(Color.BLUE);
        }else if(counter > 49 && counter < 85) {
            circle.setFill(Color.RED);
        }else if(counter > 84 && counter < 101) {
            circle.setFill(Color.DARKGREEN);
        }else{
            circle.setFill(Color.RED);
        }
    }


    public void paint () {
        refresh();
        setColor();
        group.getChildren().add(this.circle);
    }

    public void destroy() {
        group.getChildren().remove(circle);
    }

    public void refresh () {
        this.circle.setCenterX(this.positionX);
        this.circle.setCenterY(this.positionY);
        this.circle.setRadius(this.radius);
    }

    public double getRadian() {
        return radius;
    }

    public void setRadian(double radius) {
        this.radius = radius;
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
