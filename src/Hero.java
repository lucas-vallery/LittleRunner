import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);
        this.setxWindow(720);
        this.setyWindow(490);
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(heroHeight);
    }

    public int getHeroHeight () {return heroHeight;}

    public void render (long time) {
        time = time/30000000;
        this.getImage().setImage(new Image("file:img/PNG Sequences/Walking/Minotaur_02_Walking_" + String.format("%03d" , time%18) + ".png"));
    }

    public void update (long time) {
        x=x+2;
    }

    private int heroHeight = 150;
}
