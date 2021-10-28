import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public double getxWindow() {return xWindow; }

    public double getyWindow() {return yWindow; }

    public void setxWindow(double xWindow) {
        this.xWindow = xWindow;
    }

    public void setyWindow(double yWindow) {
        this.yWindow = yWindow;
    }

    protected double x;
    protected double y;
    protected double yVel;
    private String fileName;
    private ImageView image;
    private int attitude;
    private int index;
    private int timeFrame;
    private int maximumIndex;
    private double xWindow;
    private double yWindow;
    private int frameOffset;
}
