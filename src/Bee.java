public class Bee extends FlyingObject implements Award{
    private int xspeed = 1;
    private int yspeed = 2;
    private int awardType;

    /** Initialization*/
    public Bee(){
        this.image = ShootGame.bee;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
        awardType = rand.nextInt(2);        //初始化时给奖励
    }

    public int getType(){
        return awardType;
    }

    /** 越界处理*/
    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT;
    }

    @Override
    public void step() {
        x += xspeed;
        y += yspeed;
        if(x > ShootGame.WIDTH - width){
            xspeed = -1;
        }
        if(x < 0){
            xspeed = 1;
        }
    }
}

