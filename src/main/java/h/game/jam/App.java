/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package h.game.jam;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application{
    static Integer counter = 0;
    static Integer lvl = 1;
    static boolean pauza;
    ArrayList<Enemy> enemies = new ArrayList<>();
    Group group = new Group();
    Scene scene = new Scene(group, 1000, 1000, Color.DEEPSKYBLUE);

    public void start(Stage primaryStage) throws Exception {

    }

    public void stage1(Stage primaryStage) {
        window(primaryStage);
    }

    public void window(Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game_Jam");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }

    public void hud() {
        TextSquare score = new TextSquare(counter,11,22, group, scene);
        score.eventOnMove();
        TextSquare left = new TextSquare(enemies.size(),920,22,group,scene);
        left.eventOnMoveSize();
    }

    public void weapon() {
        Block weapon = new Block(508, 910, 40, 10, Color.RED, group, scene);
        weapon.eventOnMove();
    }

    public void ground() {
        Block ground = new Block(0, 975, 100, 1000, Color.GREEN, group, scene);

    }

    public void character() {
        Block character = new Block(500, 925, 50, 25, Color.BLACK, group, scene);
    }

    public void enemies(int enemyCount) {
        for(Integer i = 1; i < enemyCount+1; i++) {
            enemies.add(new Enemy(22, Math.random()*1000, -i*(int)(Math.random()*55), group, scene, i));
            enemies.get(i-1).paint();
            enemies.get(i-1).eventOnMove();
            enemies.get(i-1).eventOnClick();
        }
    }
}