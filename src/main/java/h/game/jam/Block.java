package h.game.jam;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Block {
    double positionX;
    double positionY;
    double height;
    double width;
    Color color;
    Group group;
    Scene scene;
    Rectangle name = new Rectangle();


    public Block(double positionX, double positionY, double height, double width, Color color, Group group, Scene scene) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.height = height;
        this.width = width;
        this.color = color;
        this.group = group;
        this.scene = scene;
    }

    public void destroy() {
        group.getChildren().remove(name);
    }

    public void eventOnMove() {
        double centerX = this.name.getX();
        double centerY = this.name.getY();
        this.scene.setOnMouseMoved((EventHandler<MouseEvent>) mouseEvent -> {
            if (App.pauza) {
                App.point = MouseInfo.getPointerInfo().getLocation();
            double angle = Math.toDegrees(Math.atan2(App.point.getX() - centerX - this.scene.getWindow().getX() - this.width,
                    App.point.getY() - centerY - this.scene.getWindow().getY() - this.height));
            this.name.setRotate(-angle);}
        });
    }

    protected void eventOnExit() {
        name.setOnMouseExited((EventHandler<MouseEvent>) mouseEvent -> {
            eventOnEnter();
        });
    }

    protected void eventOnEnter() {
        name.setOnMouseEntered((EventHandler<MouseEvent>) mouseEvent -> {
          App.pauza = true;
          group.getChildren().remove(name);
        });
    }

    public void paint () {
        refresh();
        group.getChildren().add(name);
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        refresh();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        refresh();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        refresh();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
        refresh();
    }

    public Rectangle getName() {
        return name;
    }

    public void setName(Rectangle name) {
        this.name = name;
        refresh();
    }

    public void refresh() {
        this.name.setX(this.positionX);
        this.name.setY(this.positionY);
        this.name.setFill(this.color);
        this.name.setHeight(this.height);
        this.name.setWidth(this.width);
    }
}
