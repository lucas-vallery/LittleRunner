import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.effect.ColorAdjust;

public class StartingScene extends Scene {

    public StartingScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;

        group.getChildren().add(left.getImage());
        group.getChildren().add(start.getImage());
        render();
    }

    public void render(){
        //Setting the background
        left.getImage().setViewport(new Rectangle2D(0,0,left.getX(),left.getY()));
        left.getImage().setX(0);
        left.getImage().setY(0);


        //Setting the start button
        ColorAdjust blackout = new ColorAdjust();
        blackout.setBrightness(-0.2);

        start.getImage().setPreserveRatio(true);
        start.getImage().setFitHeight(80);
        start.getImage().setX(170);
        start.getImage().setY(160);
        start.getImage().setEffect(new DropShadow(50, Color.BLACK));
        start.getImage().setEffect(blackout);
    }

    private StaticThings left = new StaticThings("file:img\\foret.png",800,600);
    private StaticThings start = new StaticThings("file:img\\starting_button.png",539,171);
    private Camera camera;
    private Hero perso = new Hero("file:img\\PNG Sequences\\Idle Blink\\Minotaur_02_Idle Blinking_000.png", 300, 0);
    private double v;
    private double v1;
}
