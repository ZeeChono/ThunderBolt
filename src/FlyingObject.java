import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    protected int x;            // x coordinate
    protected int y;            // y coordinate
    protected int width;
    protected int height;
    protected BufferedImage image;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Check if the FlyingObject is out of bounds
     * @return boolean
     */
    public abstract boolean outOfBounds();

    /**
     * Move the object by one step
     */
    public abstract void step();

    /**
     * Check if the object is shoot by others
     * @param bullet
     * @return
     */
    public boolean shootBy(Bullet bullet){
        int x = bullet.x;
        int y = bullet.y;
        return true;
    }
}
