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
        refresh();
        this.group.getChildren().add(this.name);
    }

    public void eventOnMove() {
        final Point[] point = {new Point()};
        double centerX = this.name.getX();
        double centerY = this.name.getY();
        this.scene.setOnMouseMoved((EventHandler<MouseEvent>) mouseEvent -> {
            point[0] = point[0] = MouseInfo.getPointerInfo().getLocation();
            double angle = Math.toDegrees(Math.atan2(point[0].getX() - centerX - this.scene.getWindow().getX() - this.width,
                    point[0].getY() - centerY - this.scene.getWindow().getY() - this.height));
            this.name.setRotate(-angle);
        });
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
