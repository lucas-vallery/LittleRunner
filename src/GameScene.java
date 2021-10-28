import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        timer.start();
        camera = new Camera(100,0, perso);
        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        group.getChildren().add(perso.getImage());
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                //System.out.println("Jump");
                perso.jump();
            }
        });
        render();
    }

    public void render(){
        double xCam = camera.getX();
        double offsetLeft = xCam%left.getX();

        left.getImage().setViewport(new Rectangle2D(offsetLeft,0,left.getX()-offsetLeft,left.getY()));
        right.getImage().setX(left.getX()-offsetLeft);

        perso.getImage().setViewport((new Rectangle2D(0, 0, perso.getxWindow(), perso.getyWindow())));
        perso.getImage().setY(v1-(perso.getHeroHeight()+perso.getY())-40);
    }


    private Camera camera;
    private StaticThings left = new StaticThings("file:img\\foret.png",800,600);
    private StaticThings right = new StaticThings("file:img\\foret.png",800,600);
    private Hero perso = new Hero("file:img\\PNG Sequences\\Idle Blink\\Minotaur_02_Idle Blinking_000.png", 300, 0);
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            perso.update(time);
            camera.update(time);
            perso.render(time);
            render();
        }
    };
    private double v;
    private double v1;
}
