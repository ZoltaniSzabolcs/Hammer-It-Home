import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuExample extends JFrame {
    public MenuExample() {
        CardLayout layout = new CardLayout();
        JPanel cardPanel = new JPanel(); //fontos
        cardPanel.setLayout(layout);
        add(cardPanel);

        try {
            BufferedImage backgroundImage = ImageIO.read(new File("res/menu/menu_background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.setBackground(getBackground());

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Content of Panel 1");
        JButton b1 = new JButton("To Panel 2");
        p1.add(l1);
        p1.add(b1);
        cardPanel.add(p1, "P1");

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Content of Panel 2");
        JButton b2 = new JButton("To Panel 1");
        p2.add(l2);
        p2.add(b2);
        cardPanel.add(p2, "P2");

        b1.addActionListener(e -> layout.show(cardPanel, "P2"));
        b2.addActionListener(e -> layout.show(cardPanel, "P1"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
