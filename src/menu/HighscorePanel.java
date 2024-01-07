package menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HighscorePanel extends JPanel {
    private BufferedImage backgroundImage;
    private MenuFrame menuFrame;
    public HighscorePanel(int width, int height, MenuFrame menuFrame){
        this.menuFrame = menuFrame;
        this.setBackground(new Color(219, 221, 198));
        {
            try {
                backgroundImage = ImageIO.read(new File("res/menu/highscores_background.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Score> leftScores;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("res/highscores.txt"));
            leftScores = bufferedReader.lines().map(s -> {
                String[] tokens = s.split(" ");
                if(tokens.length < 4){
                    return null;
                }

                return new Score(tokens[0], tokens[2], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[3]));
            }).sorted(Comparator.comparing(Score::getLeftHandScore)).collect(Collectors.toList()).reversed();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Score> rightScores;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("res/highscores.txt"));
            rightScores = bufferedReader.lines().map(s -> {
                String[] tokens = s.split(" ");
                if(tokens.length < 4){
                    return null;
                }
                return new Score(tokens[0], tokens[2], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[3]));
            }).sorted(Comparator.comparing(Score::getRightHandScore)) .collect(Collectors.toList()).reversed();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        JTextArea leftHandLabel = new JTextArea();
        JTextArea rightHandLabel = new JTextArea();

        int dist = 10;
        leftHandLabel.setBounds(175 + dist, 240, 200, 300);
//        leftHandLabel.setMinimumSize(new Dimension(200, 300));
        leftHandLabel.setFont(new Font("Stencil", Font.BOLD, 16));
        leftHandLabel.setBackground(new Color(219, 221,198));
        leftHandLabel.setForeground(Color.BLACK);
        leftHandLabel.setOpaque(false);
        leftHandLabel.setEditable(false);

        rightHandLabel.setBounds(615 - dist - 200, 240, 200,300);
        rightHandLabel.setFont(new Font("Stencil", Font.BOLD, 16));
        rightHandLabel.setBackground(new Color(219, 221,198));
        rightHandLabel.setForeground(Color.BLACK);
        rightHandLabel.setOpaque(false);
        rightHandLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        rightHandLabel.setEditable(false);

        for(int i = 0; i < 10 && i < leftScores.size(); i++){
//            System.out.println(leftHandLabel.getText();
//            leftHandLabel.setText("<html>" + leftHandLabel.getText() + leftScores.get(i).getLeftHandName() + " " + leftScores.get(i).getLeftHandScore() + "<br></html>");
            leftHandLabel.append(leftScores.get(i).getLeftHandName() + " " + leftScores.get(i).getLeftHandScore() + "\n");
        }
        for(int i = 0; i < 10 && i < rightScores.size(); i++){
//            rightHandLabel.setText(rightHandLabel.getText() + rightScores.get(i).getRightHandName() + " " + rightScores.get(i).getRightHandScore() + "\n");
            rightHandLabel.append(rightScores.get(i).getRightHandName() + " " + rightScores.get(i).getRightHandScore() + "\n");
        }

        add(leftHandLabel);
        add(rightHandLabel);
        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
