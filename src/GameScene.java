import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        camera = new Camera(1500,0);
        group.getChildren().add(left.getImage());
        render();

    }

    private Camera camera;
    private StaticThings left = new StaticThings("C:\\Users\\lucas\\IdeaProjects\\runner\\img\\desert.png",800,600);
    private StaticThings right = new StaticThings("C:\\Users\\lucas\\IdeaProjects\\runner\\img\\desert.png",800,600);

    public void render(){
        double xCam=camera.getX();
        double offsetLeft=xCam%left.getX();

        left.getImage().setViewport(new Rectangle2D(offsetLeft,0,left.getX()-offsetLeft,left.getY()));

    }

}
