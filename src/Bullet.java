public class Bullet extends FlyingObject{
    private int speed = 3;

    /** 初始化*/
    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        image = ShootGame.bullet;
    }

    /** 移动*/
    @Override
    public void step() {
        y = -speed;
    }

    /** 越界处理*/
    @Override
    public boolean outOfBounds() {
        return y < -height;
    }
}
