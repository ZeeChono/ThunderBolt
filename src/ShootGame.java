import javax.swing.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class ShootGame extends JPanel {
    public static void main(String[] args){
        JFrame frame = new JFrame("Fly");
        ShootGame game = new ShootGame();       // 面板对象
        frame.add(game);                        // 将面板添加到frame中去
        frame.setSize(WIDTH, HEIGHT);
        frame.setAlwaysOnTop(true);             // 设置其总在最上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 默认关闭操作
        frame.setIconImage(new ImageIcon("images/icon.jpg").getImage());    //设置窗体的图标
        frame.setLocationRelativeTo(null);      // 设置窗体初始位置
        frame.setVisible(true);                 // 尽快调用paint

        game.action();                          // 启动执行
    }

    public static final int WIDTH = 400;
    public static final int HEIGHT = 654;
    /** 游戏当前状态: START RUNNING PAUSE GAME_OVER*/
    private int state;
    private static final int START = 0;
    private static final int RUNNING = 1;
    private static final int PAUSE = 2;
    private static final int GAME_OVER = 3;

    private int score = 0;
    private Timer timer;
    private int interval = 1000/100;    // 时间间隔（毫秒）

    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage airplane;
    public static BufferedImage bee;
    public static BufferedImage bullet;
    public static BufferedImage hero0;
    public static BufferedImage hero1;
    public static BufferedImage pause;
    public static BufferedImage gameover;

    private FlyingObject[] flyings = {};    // 敌机数组
    private Bullet[] bullets = {};          // 子弹数组
    private Hero hero = new Hero();         // 英雄机（你）

    static{     // 静态代码块，初始化图片资源，静态代码块优先于主函数且只运行一次
        try{
            background = ImageIO.read(ShootGame.class.getResource("background.png"));
            start = ImageIO.read(ShootGame.class.getResource("start.png"));
            airplane = ImageIo.read(ShootGame.class.getResource("airplane.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
