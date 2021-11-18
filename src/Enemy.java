import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class Enemy extends AnimatedThings{

    public Enemy () {
        super("file:img/Enemy/Walking/Minotaur_01_Walking_000.png", 0, 0);
        this.setX(500+ (int)(Math.random() * ((10000 - 600) + 1)));

        //Loading images in ram
        walkingSequence = new ArrayList<>(18);
        for (int i = 0; i < 18; i++) {
            walkingSequence.add(new Image("file:img/Enemy/Walking/Minotaur_01_Walking_" + String.format("%03d" , i) + ".png"));
        }

        //Setting the enemy appearance
        maximumIndex = 17;
        this.setxWindow(720);
        this.setyWindow(490);
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(enemyHeight);

        this.hitBox = new Rectangle(55, this.y, this.enemyWidth-40, this.enemyWidth-20);
        this.hitBox.setFill(Color.TRANSPARENT);
        this.hitBox.setStroke(Color.RED);
        this.hitBox.setStrokeWidth(3);
    }

    public void render (long time) {
        //Updating the hero appearance based on the current time
        getImage().setImage(walkingSequence.get(index));
        getImage().setViewport((new Rectangle2D(0, 0, xWindow, yWindow)));
        getImage().setY(400-(enemyHeight+y)-40);
        this.hitBox.setY(400-(enemyHeight+y)-30);
        this.hitBox.setX(x+50);
        getImage().setX(x);
    }

    public void update (long time) {
        //Walking
        x-=4;

        //Updating the index of the image to display
        time = time/30000000;
        index = (int) (time % (maximumIndex + 1));
    }

    private int enemyHeight = 150;
    private int enemyWidth = 150; //150*720/490;
}
