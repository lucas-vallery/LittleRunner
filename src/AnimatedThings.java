import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public abstract class AnimatedThings {

    public AnimatedThings (String fileName, double x, double y){
        this.x =x;
        this.y = y;
        this.fileName = fileName;
        this.frameOffset = 0;
        this.image = new ImageView(new Image(fileName));
    }


    public ImageView getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getxWindow() {
        return xWindow;
    }

    public double getyWindow() {
        return yWindow;
    }

    public void setxWindow(double xWindow) {
        this.xWindow = xWindow;
    }

    public void setyWindow(double yWindow) {
        this.yWindow = yWindow;
    }

    public Rectangle getHitBox() { return hitBox; }

    public void setAttitude(int attitude){
        this.attitude = attitude;
    }

    protected double x;
    protected double y;
    protected double yVel;
    protected Rectangle hitBox;
    private String fileName;
    private ImageView image;
    protected int attitude;
    protected int index;
    protected int maximumIndex;
    protected double xWindow;
    protected double yWindow;
    protected int frameOffset;
    protected ArrayList<Image> walkingSequence;
    protected ArrayList<Image> idlingSequence;
    protected int timeDivider;
}
