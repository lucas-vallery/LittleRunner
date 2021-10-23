import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        camera = new Camera(1205,0);
        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        render();

    }

    private Camera camera;
    private StaticThings left = new StaticThings("C:\\Users\\lucas\\IdeaProjects\\runner\\img\\desert.png",800,600);
    private StaticThings right = new StaticThings("C:\\Users\\lucas\\IdeaProjects\\runner\\img\\desert.png",800,600);
    private double v;

    public void render(){
        double xCam=camera.getX();
        double offsetLeft = xCam%left.getX();

        left.getImage().setViewport(new Rectangle2D(offsetLeft,0,left.getX()-offsetLeft,left.getY()));
        right.getImage().setViewport(new Rectangle2D(0, 0, v-(left.getX()-offsetLeft), right.getY()));
        right.getImage().setX(left.getX()-offsetLeft);
    }

}
