import javafx.scene.image.Image;

public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);

        //Setting the hero appearance
        this.setxWindow(720);
        this.setyWindow(490);
        this.getImage().setPreserveRatio(true);
        this.getImage().setFitHeight(heroHeight);

    }

    public int getHeroHeight () {return heroHeight;}

    public void render (long time) {
        //Updating the hero appearance based on the current time
        time = time/30000000;
        this.getImage().setImage(new Image("file:img/PNG Sequences/Walking/Minotaur_02_Walking_" + String.format("%03d" , time%18) + ".png"));
    }

    public void jump () {
        //Adding a vertical acceleration to the hero
        if(y <= 0)
            yVel += 8;
    }
    public void update (long time) {
        //Walking
        x=x+3;

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
