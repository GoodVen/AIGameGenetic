package source;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame(  "Game");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       startFrame.setLocation(0,0);
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       startFrame.setSize(screenSize);
       startFrame.add(new Panel());

        startFrame.setVisible(true);


    }
}
