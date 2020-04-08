package h.game.jam;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TextSquare {
    ArrayList<Node> childrens = new ArrayList<>();
    Text text = new Text();
    String string;
    int positionX;
    int positionY;
    boolean frame;
    Group group;
    Scene scene;

    public TextSquare(String string, int positionX, int positionY, Group group, Scene scene) {
        this.string = string;
        this.positionX = positionX;
        this.positionY = positionY;
        this.group = group;
        this.scene = scene;
        childrens.add(text);
    }

    public void eventOnMove() {
        this.scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                setString(App.counter);
                refresh();
            }
        });
    }

    public void eventOnMoveSize() {
        this.scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                setString(App.enemiesLeft);
                refresh();
            }
        });
    }

    public void eventOnClick() {
        childrens.get(2).setOnMouseClicked((EventHandler<MouseEvent>) mouseEvent -> {
            destroy();
            App.pauza = true;
        });
    }

    public void eventOnMoveMenu() {
        this.scene.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                if(!App.pauza && !group.getChildren().contains(text)) {
                    paint();
                }else if(App.pauza && group.getChildren().contains(text)) {
                    destroy();
                }
            }
        });
    }

    public void bacground(int padding, int lenght, int height) {
        Rectangle back = new Rectangle();
        Rectangle bback = new Rectangle();
        childrens.add(bback);
        childrens.add(back);
        back.setX(positionX-(int)(lenght/4));
        back.setY(positionY-(int)(height/2));
        back.setFill(Color.GRAY);
        back.setWidth(lenght);
        back.setHeight(height);
        bback.setX(back.getX()-padding);
        bback.setY(back.getY()-padding);
        bback.setFill(Color.BLACK);
        bback.setWidth(lenght+2*padding);
        bback.setHeight(height+2*padding);
    }

    public void destroy() {
        group.getChildren().removeAll(childrens);
    }

    public void paint() {
        refresh();
        group.getChildren().addAll(childrens);
    }

    public void refresh() {
        text.setText(string);
        text.setX(positionX);
        text.setY(positionY);
        //text.set
    }

    public String getString() {
        return string;
    }

    public void setString(Integer string) {
        this.string = string.toString();
        refresh();
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
        refresh();
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
        refresh();
    }

    public boolean isFrame() {
        return frame;
    }

    public void setFrame(boolean frame) {
        this.frame = frame;
        refresh();
    }
}
