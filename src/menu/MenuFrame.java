package menu;

import game.GameFrame;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private final int width = 800;
    private final int height = 800;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MenuPanel menuPanel;
    private HelpPanel helpPanel;
    private HighscorePanel highscorePanel;

    public MenuFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        add(mainPanel);

        //JPanel panel1 = createPanel("Panel 1", Color.RED);
        menuPanel = new MenuPanel(width, height, this);
        mainPanel.add(menuPanel, "menu");

        //JPanel panel2 = createPanel("Panel 2", Color.GREEN);
        helpPanel = new HelpPanel(width, height, this);
        mainPanel.add(helpPanel, "help");

        //JPanel panel3 = createPanel("Panel 3", Color.BLUE);
        highscorePanel = new HighscorePanel(width, height, this);
        mainPanel.add(highscorePanel, "highscores");


        double scale = 1.25;
        int nrButtons = 3;
        JButton button1 = new JButton("Show menu");
        button1.addActionListener(e -> cardLayout.show(mainPanel, "menu"));
        SetupButton(button1);

        JButton button2 = new JButton("Show help");
        button2.addActionListener(e -> cardLayout.show(mainPanel, "help"));
        SetupButton(button2);

        JButton button3 = new JButton("Show highscores");
        button3.addActionListener(e -> cardLayout.show(mainPanel, "highscores"));
        SetupButton(button3);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.setBackground(new Color(219, 221, 198));

        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Hammer It Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void SetupButton(JButton button){
        button.setBackground(new Color(219, 221,198));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(new Color(169, 171, 158), 2));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusable(false);
    }
    public void showMenuPanel() {
        cardLayout.show(mainPanel, "menu");
        menuPanel.repaint();
    }

    public void showHelpPanel() {
        cardLayout.show(mainPanel, "help");
        helpPanel.repaint();
    }

    public void showHighscoresPanel() {
        cardLayout.show(mainPanel, "highscores");
        highscorePanel.repaint();
    }

    public void startGame(){
        if(!menuPanel.getNameField().getText().equals("") && !menuPanel.getNameField2().getText().equals("")){
            setVisible(false);
            this.dispose();
            new GameFrame(menuPanel.getNameField().getText(), menuPanel.getNameField2().getText());
        }
        else{
            menuPanel.cannotStart();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuFrame frame = new MenuFrame();
        });
    }
}
