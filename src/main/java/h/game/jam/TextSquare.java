package h.game.jam;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TextSquare {
    Text text = new Text();
    String string;
    int positionX;
    int positionY;
    boolean frame;
    Group group;
    Scene scene;

    public TextSquare(Integer string, int positionX, int positionY, Group group, Scene scene) {
        this.string = string.toString();
        this.positionX = positionX;
        this.positionY = positionY;
        this.group = group;
        this.scene = scene;
        refresh();
        paint();
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
                setString(group.getChildren().size()-5);
                refresh();
            }
        });
    }

    public void paint() {
        refresh();
        group.getChildren().add(text);
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
