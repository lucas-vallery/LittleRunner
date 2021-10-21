public class Camera {
    public Camera (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }

    private int x;
    private int y;
}
