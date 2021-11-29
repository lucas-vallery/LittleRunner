import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        timer.start();
        camera = new Camera(0,0, perso);
        startingText = new CustomText(180, 110, 45, "<Press any key>\n>to start<", ">Press any key<\n<to start>");
        resumingText = new CustomText(180, 110, 45, "<Press any key>\n>to resume<", ">Press any key<\n<to resume>");


        for (int i = 0; i < 10; i++) {
            foes.add(new Enemy());
        }

        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        for (Enemy foe: foes) {
            group.getChildren().add(foe.getImage());
           // group.getChildren().add(foe.getHitBox());
        }
        //group.getChildren().add(perso.getHitBox());
        group.getChildren().add(perso.getImage());
        group.getChildren().add(startingText.getText());


        //Triggering a jump when space is pressed
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE && start) {
                perso.jump();
            }
            else if (event.getCode() == KeyCode.ESCAPE && start && !perso.isDead()) {
                start = false;
                group.getChildren().add(resumingText.getText());
                perso.setAttitude(0);
            }
            else if (!start) {
                start = true;
                group.getChildren().remove(startingText.getText());
                group.getChildren().remove(resumingText.getText());
                perso.setAttitude(1);
            }
        });
        render();
    }

    public void render(){
        //Displaying the hero
        perso.getImage().setX(perso.getX() - camera.getX());
        perso.getHitBox().setX(perso.getX() - camera.getX()+60);
        perso.getImage().setY(v1-(perso.getHeroHeight()+perso.getY())-40);
        perso.getHitBox().setY(v1-(perso.getHeroHeight()+perso.getY())-30);

        //Displaying the background based on the position of the camera
        double xCam = camera.getX();
        double offsetLeft = xCam%left.getX();
        left.getImage().setViewport(new Rectangle2D(offsetLeft,0,left.getX()-offsetLeft,left.getY()));
        right.getImage().setX(left.getX()-offsetLeft);
    }

    private double v;
    private double v1;
    private Camera camera;
    private boolean start = false;

    private StaticThings left = new StaticThings("file:img\\foret.png",800,400);
    private StaticThings right = new StaticThings("file:img\\foret.png",800,400);

    private Hero perso = new Hero("file:img\\PNG Sequences\\Idle Blink\\Minotaur_02_Idle Blinking_000.png", 0, 0);

    private ArrayList<Enemy> foes = new ArrayList<>(30);
    private CustomText startingText;
    private CustomText resumingText;

    //Counting the time and refreshing the game scene
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            camera.update(time);
            perso.update(time);
            perso.render(time);

            if(!start) {
                startingText.render(time);
                resumingText.render(time);
                for (Enemy foe : foes) {
                    foe.render(time);
                }
            }
            else {
                for (Enemy foe : foes) {
                    foe.update(time);
                    foe.render(time);
                    if (perso.getHitBox().intersects(foe.getHitBox().getX(), foe.getHitBox().getY(), foe.getHitBox().getWidth(), foe.getHitBox().getHeight())) {
                        if (!perso.isInvincible() && !(perso.hitBox.getY()<foe.hitBox.getY())) {
                            perso.setAttitude(2);
                        }
                        if(perso.hitBox.getY()<foe.hitBox.getY()){
                            perso.bounce();
                            foe.hitBox.setHeight(1);
                            foe.hitBox.setY(foe.hitBox.getY()+250);
                            foe.getImage().setFitHeight(1);                        }
                    }
                }
            }
            render();
        }
    };
}
