import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {

    private BufferedImage images[] = {};
    private int index = 0;

    private int doubleFire;         // double fire damage
    private int life;               // hitpoints of hero

    public Hero(){
        life = 3;
        doubleFire = 0;
        images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};     // hero images
        image = ShootGame.hero0;
        width = image.getWidth();
        height = image.getHeight();
        x = 150;
        y = 400;
    }

    /**
     * return true if your hero is strengthened
     * @return
     */
    public int isDoubleFire(){
        return doubleFire;
    }

    public void setDoubleFire(int doubleFire) {
        this.doubleFire = doubleFire;
    }

    /**
     * increase your hero's attack damage
     */
    public void addDoubleFire(){
        doubleFire = 40;
    }

    /** add an additional life to your hero */
    public void addLife(){
        life++;
    }
    /** subtract life*/
    public void subtractLife(){
        life--;
    }
    /** getLife*/
    public int getLife() {
        return life;
    }

    public void moveTo(int x, int y){
        this.x = x - width/2;
        this.y = y - height/2;
    }

    @Override
    public boolean outOfBounds() {
        return false;
    }

    /**
     * shoot the enemy
     * @return
     */
    public Bullet[] shoot(){
        int xStep = width/4;
        int yStep = 20;
        if(doubleFire > 0){     // if your hero is doubleFired
            Bullet bullets[] = new Bullet[2];
            bullets[0] = new Bullet(x+xStep, y-yStep);  // y-yStep: the distance between bullet and flight
            bullets[1] = new Bullet(x+3*xStep, y-yStep);
            return bullets;
        }else{                  // if your hero is not doubleFired
            Bullet[] bullets = new Bullet[1];
            bullets[0] = new Bullet(x+2*xStep, y-yStep);
            return bullets;
        }
    }

    /** 移动 */
    @Override
    public void step() {
        if(images.length > 0){
            image = images[index++/10%images.length];
        }
    }

    /** 碰撞算法*/   // >>>>>>>>>>>>>>>>>>>> ??????????????????>>>>>>>>>>>>>>
    public boolean hit(FlyingObject other){

        int x1 = other.x - this.width/2;                    // x min distance
        int x2 = other.x + this.width/2 + other.x;          // x max distance
        int y1 = other.y - this.height/2;                   // y min distance
        int y2 = other.y + this.height/2 + other.height;    // y max distance

        int herox = this.x + this.width/2;
        int heroy = this.y + this.height/2;                 // hero's central point

        return herox > x1 && herox < x2 && heroy > y1 && heroy < y2;
    }
}
