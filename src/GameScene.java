import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        camera = new Camera(300,0);
        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        group.getChildren().add(perso.getImage());
        render();

    }

    private Camera camera;
    private StaticThings left = new StaticThings("file:img\\desert.png",800,600);
    private StaticThings right = new StaticThings("file:img\\desert.png",800,600);
    private Hero perso = new Hero("file:img\\PNG Sequences\\Idle Blink\\Minotaur_02_Idle Blinking_000.png", 300, 0);
    private double v;
    private double v1;

    public void render(){
        double xCam = camera.getX()+200;
        double offsetLeft = xCam%left.getX();

        left.getImage().setViewport(new Rectangle2D(offsetLeft,0,left.getX()-offsetLeft,left.getY()));
        right.getImage().setViewport(new Rectangle2D(0, 0, v-(left.getX()-offsetLeft), right.getY()));
        right.getImage().setX(left.getX()-offsetLeft);

        perso.getImage().setViewport((new Rectangle2D(0, 0, perso.getxWindow(), perso.getyWindow())));
        perso.getImage().setY(v1-perso.getHeroHeight());


    }

}
