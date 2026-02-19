package baccaratgame;
import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    GameFrame frame;

    public Menu(GameFrame frame) {
        this.frame = frame;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 800));

        JLabel bg = background();
        bg.setBounds(0, 0, 800, 800);
        this.add(bg);
    }

    private JButton startButton() {
        JButton startButton = new JButton("START GAME");
        startButton.addActionListener(e -> {
            frame.startGame();
        });

        startButton.setBackground(new Color(184, 134, 11));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.setFont(new Font("Arial", Font.BOLD, 18));

        return startButton;
    }

    private JButton exitButton() {
        JButton exitButton = new JButton("EXIT GAME");
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        exitButton.setBackground(new Color(60, 0, 0));
        exitButton.setForeground(new Color(255, 215, 0));
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));

        return exitButton;
    }

    private JLabel background() {
        java.net.URL imgURL = getClass().getResource("/Baccaratimgame/Game front page.jpg");
        ImageIcon background;

        int w = 800;
        int h = 800;

        if (imgURL != null) {
            ImageIcon originalIcon = new ImageIcon(imgURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            background = new ImageIcon(scaledImage);
        } else {
            background = new ImageIcon();
        }

        JLabel label = new JLabel(background);
        label.setLayout(null);

        int bx = (w / 2) - (220 / 2);

        JButton start = startButton();
        start.setBounds(bx, 620, 220, 50);
        label.add(start);

        JButton exit = exitButton();
        exit.setBounds(bx, 680, 220, 50);
        label.add(exit);

        return label;
    }
}