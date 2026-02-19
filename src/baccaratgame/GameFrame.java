package baccaratgame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Baccarat Game");
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        showMenu();
        this.setVisible(true);
    }

    public void showMenu() {
        getContentPane().removeAll();
        this.setLayout(new GridBagLayout());
        Menu menu = new Menu(this);
        this.add(menu, new GridBagConstraints());
        this.pack();
        this.setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    public void startGame(){
        this.getContentPane().removeAll();
        this.setLayout(new GridBagLayout());
        GamePanel panel = new GamePanel(this);
        this.add(panel, new GridBagConstraints());
        this.pack();
        this.setLocationRelativeTo(null);
        this.revalidate();
        this.repaint();
        panel.requestFocus();
    }
}