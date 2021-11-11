import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);

        //Loading images in ram
        imageList = new ArrayList<>(18);
        for (int i = 0; i < 18; i++) {
        imageList.add(new Image("file:img/PNG Sequences/Walking/Minotaur_02_Walking_" + String.format("%03d" , i) + ".png"));
        }

        //Setting the hero appearance
        maximumIndex = 17;
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(heroHeight);

    }

    public int getHeroHeight () {return heroHeight;}

    public void render (long time) {
        //Updating the hero appearance based on the index value
        getImage().setImage(imageList.get(index));
    }

    public void jump () {
        //Adding a vertical acceleration to the hero
        if(y <= 0)
            yVel += 9;
    }
    public void update (long time) {
        //Updating the index of the image to display
        time = time/30000000;
        index = (int) (time % (maximumIndex + 1));

        //Walking
        x+=3;

        //Computing the gravity effect
        y += yVel;
        yVel -= 0.2;

        //Making the floor solid
        if(y <= 0) {
            y = 0;
            yVel =0;
        }
    }

    private int heroHeight = 150;
}
