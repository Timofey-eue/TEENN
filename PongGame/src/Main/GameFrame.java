package Main;

import Main.GameVisible;

import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {

    GameVisible panel;

    public GameFrame() {
        panel = new GameVisible();
        this.add(panel);
        this.setTitle("OnlineTennis");
        this.setContentPane(new GameVisible());
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}