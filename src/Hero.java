import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);

        //Loading images in ram
        walkingSequence = new ArrayList<>(18);
        for (int i = 0; i < 18; i++) {
            walkingSequence.add(new Image("file:img/PNG Sequences/Walking/Minotaur_02_Walking_" + String.format("%03d" , i) + ".png"));
        }

        idlingSequence = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            idlingSequence.add(new Image("file:img/PNG Sequences/Idle/Minotaur_02_Idle_" + String.format("%03d" , i) + ".png"));
        }

        dyingSequence = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            dyingSequence.add(new Image("file:img/PNG Sequences/Dying/Minotaur_02_Dying_" + String.format("%03d" , i) + ".png"));
        }

        attitude = 0;
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(heroHeight);
        this.hitBox = new Rectangle(this.x, this.y, this.heroWidth-60, this.heroHeight-20);
        this.hitBox.setFill(Color.TRANSPARENT);
        this.hitBox.setStroke(Color.RED);
        this.hitBox.setStrokeWidth(3);

    }

    public int getHeroHeight () {return heroHeight;}

    public void render (long time) {
        //Updating the hero appearance based on the index value

        //Idling sequence
        if(attitude == 0) {
            getImage().setImage(idlingSequence.get(index));
        }

        //Walking sequence
        if(attitude == 1) {
            getImage().setImage(walkingSequence.get(index));
        }

        //Dying sequence
        if(attitude == 2 && !isDead) {
            getImage().setImage(dyingSequence.get(index));
            if(index > maximumIndex-1)
                isDead = true;
        }

    }

    public void jump () {
        //Adding a vertical acceleration to the hero
        if(y <= 0 && y < 100 && !isDead)
            yVel += 10;
    }
    public void bounce () {
        //Adding a vertical acceleration to the hero
        if(!isDead && y<400-200 && oldY>y)
            yVel += 5;
    }

    public void addInvincibility () {
        invincibility =  250;
    }

    public boolean isDead () {
        return isDead;
    }

    public boolean isInvincible () {
        if(invincibility > 0)
            return true;
        else
            return false;
    }

    public void update (long time) {

        //Idling
        if(attitude == 0){
            timeDivider = 80000000;
            maximumIndex = 11;
            //Do nothing
        }

        //Walking
        if(attitude == 1) {
            timeDivider = 30000000;
            maximumIndex = 17;
            x+=3;
        }

        //Dying
        if(attitude == 2 && !isDead) {
            timeDivider = 30000000;
            maximumIndex = 14;
        }

        if(invincibility > 0)
            invincibility -= 1;

        //Updating the index of the image to display
        time = time/timeDivider;
        index = (int) (time % (maximumIndex + 1));

        //Computing the gravity effect
        oldY = y;
        y += yVel;
        yVel -= 0.2;

        //Making the floor solid
        if(y <= 0) {
            y = 0;
            yVel =0;
        }
    }

    public void dying () {

    }

    private double invincibility;
    private double oldY;
    private int heroHeight = 150;
    private int heroWidth = 150;
    private Boolean isDead = false;
}
