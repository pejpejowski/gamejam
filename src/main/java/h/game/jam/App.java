/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package h.game.jam;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class App extends Application{
    static Point point = new Point();
    static Integer enemiesLeft;
    static Integer counter = 0;
    static Integer lvl = 1;
    static boolean pauza = true;
    ArrayList<Enemy> enemies = new ArrayList<>();
    Group group = new Group();
    Scene scene = new Scene(group, 1000, 1000, Color.DEEPSKYBLUE);

    public void start(Stage primaryStage) throws Exception {
        ground();
        character();
        weapon();
        enemies(100);
        hud();
        menu();
        eventPauza();
        window(primaryStage);
    }

    public void menu() {
        TextSquare newGame = new TextSquare("New Game", 450, 100, group, scene);
            newGame.bacground(10, 100, 50);
            newGame.eventOnClick();
            newGame.eventOnMoveMenu();
    }

    public void stage1(Stage primaryStage) {

    }

    public void window(Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game_Jam");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    public void hud() {
        TextSquare score = new TextSquare(counter.toString(),11,22, group, scene);
        score.eventOnMove();
        score.paint();
        TextSquare left = new TextSquare(enemiesLeft.toString(),920,22,group,scene);
        left.eventOnMoveSize();
        left.paint();
    }

    public void weapon() {
        Block weapon = new Block(508, 910, 40, 10, Color.RED, group, scene);
        weapon.paint();
        weapon.eventOnMove();
    }

    public void ground() {
        Block ground = new Block(0, 975, 100, 1000, Color.GREEN, group, scene);
        ground.paint();
    }

    public void eventPauza() {
        this.scene.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler<MouseEvent>) e -> {
            if (pauza){
                pauza = !pauza;
                Block pauzaBlok = new Block(point.x - scene.getWindow().getX() - 21,
                        point.y - scene.getWindow().getY() - 43,30, 30, Color.PINK,
                        group, scene);
                pauzaBlok.eventOnExit();
                pauzaBlok.paint();
            }
        });
        this.scene.addEventHandler(KeyEvent.KEY_PRESSED, (EventHandler<KeyEvent>) e -> {
           if (e.getCode() == KeyCode.SPACE) {
                if (pauza){
                    pauza = !pauza;
                    Block pauzaBlok = new Block(point.x - scene.getWindow().getX() - 21,
                            point.y - scene.getWindow().getY() - 43,30, 30, Color.PINK,
                            group, scene);
                    pauzaBlok.eventOnExit();
                    pauzaBlok.paint();
                }
            }
        });
    }

    public void character() {
        Block character = new Block(500, 925, 50, 25, Color.BLACK, group, scene);
        character.paint();
    }

    public void enemies(int enemyCount) {
        for(Integer i = 1; i < enemyCount+1; i++) {
            enemies.add(new Enemy(22, Math.random()*1000, -i*(int)(Math.random()*55), group, scene, i));
            enemiesLeft = i;
            enemies.get(i-1).paint();
            enemies.get(i-1).eventOnMove();
            enemies.get(i-1).eventOnClick();
        }
    }
}