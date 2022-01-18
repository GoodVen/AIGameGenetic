package source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements Runnable {
    //Field
    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    private Thread mythread = new Thread(this);
    private BufferedImage img;
    private Graphics2D g;

    private  GameBack background;


    //Enum game status
    public static enum STATES{MENUE,PLAY}
    public static STATES state = STATES.MENUE;


    //Constructor
    public Panel() {
        super();

        setFocusable(true);
        requestFocus();
        mythread.start();
    }
    // Game logic
    @Override
    public void run() {
//init image
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g =(Graphics2D) img.getGraphics();

        background = new GameBack();
//whiletrue
        while (true) {

        gameUpdate();
        gameRender();
        gameDraw();

        try {
            mythread.sleep(33);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
            System.out.println("Error: Timer not sleep");
        }

    }
    }
    //update game komponents
    public void gameUpdate(){
        //update background
        background.update();
        //player.update();
       // enemy.update();
    }
    public void gameRender(){
        //background graphic
        background.draw(g);

    }
    private void gameDraw(){

        Graphics g2 = this.getGraphics();
        g2.drawImage(img, 0,0,null);
        g2.dispose();
    }




}
