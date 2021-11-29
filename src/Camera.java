public class Camera {
    public Camera (double x, double y, AnimatedThings c) {
        this.x = x;
        this.y = y;
        this.center = c;
    }

    public double getX() {
        return x;
    }

    public void update (long time) {
        //Following center (the hero in this case)
        x = (1-alpha)*center.getX() + alpha*x;
        //x = center.getX();
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    private double x;
    private double y;
    private double alpha = 0.90;
    private AnimatedThings center;
}
