package menu;

import game.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel {
    private BufferedImage backgroundImage;
    private MenuFrame menuFrame;
    private JTextField nameField;
    private JTextField nameField2;
    private JLabel nameLabel;
    private JLabel nameLabel2;

    public MenuPanel(int width, int height, MenuFrame menuFrame){
        this.menuFrame = menuFrame;
        this.setBackground(new Color(219, 221, 198));
        setLayout(null);
//        this.setSize(new Dimension(width, height));
        {
            try {
                backgroundImage = ImageIO.read(new File("res/menu/menu_background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        JButton startButton = new JButton("START");
        startButton.setBounds((width - 200) / 2 , 450, 200,75);
        startButton.addActionListener(e -> menuFrame.startGame());
        startButton.setBackground(new Color(219, 221,198));
        startButton.setForeground(Color.BLACK);
        startButton.setBorder(BorderFactory.createLineBorder(new Color(169, 171, 158), 2));
        startButton.setFont(new Font("Arial", Font.BOLD, 30));
        startButton.setFocusable(false);
        add(startButton);

        nameLabel = new JLabel("Left hand name:", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setBounds((width - 200) / 4, startButton.getY() + startButton.getHeight() + 30, 200,50);
        nameLabel.setBackground(new Color(219, 221,198));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);


        nameField = new JTextField(SwingConstants.CENTER);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField.setBounds((width - 200) / 4, nameLabel.getY() + nameLabel.getHeight() + 5, 200,50);
        nameField.setBackground(new Color(219, 221,198));
        nameField.setForeground(Color.BLACK);
        add(nameField);

        nameLabel2 = new JLabel("Right hand name:", SwingConstants.CENTER);
        nameLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel2.setBounds((width - 200) / 4 * 3, startButton.getY() + startButton.getHeight() + 30, 200,50);
        nameLabel2.setBackground(new Color(219, 221,198));
        nameLabel2.setForeground(Color.BLACK);
        add(nameLabel2);


        nameField2 = new JTextField(SwingConstants.CENTER);
        nameField2.setFont(new Font("Arial", Font.PLAIN, 16));
        nameField2.setBounds((width - 200) / 4 * 3, nameLabel.getY() + nameLabel.getHeight() + 5, 200,50);
        nameField2.setBackground(new Color(219, 221,198));
        nameField2.setForeground(Color.BLACK);
        add(nameField2);
    }
    public void cannotStart(){
        if(nameField.getText().equals("")){
            nameLabel.setText("Need left hand name");
        }
        else{
            nameLabel.setText("Left hand name:");
        }
        if(nameField2.getText().equals("")){
            nameLabel2.setText("Need right hand name");
        }
        else{
            nameLabel2.setText("Right hand name:");
        }
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getNameField2() {
        return nameField2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
