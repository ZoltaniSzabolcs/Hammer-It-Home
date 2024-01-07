package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HelpPanel extends JPanel {
    private BufferedImage backgroundImage;
    private MenuFrame menuFrame;
    public HelpPanel(int width, int height, MenuFrame menuFrame){
        this.menuFrame = menuFrame;
        this.setBackground(new Color(219, 221, 198));
//        this.setSize(new Dimension(width, height));
        {
            try {
                backgroundImage = ImageIO.read(new File("res/menu/help_background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
