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

    public double getxWindow() {return xWindow; }

    public double getyWindow() {return yWindow; }

    public void setxWindow(double xWindow) {
        this.xWindow = xWindow;
    }

    public void setyWindow(double yWindow) {
        this.yWindow = yWindow;
    }

    private double x;
    private double y;
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
