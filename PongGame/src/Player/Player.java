package Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;

public class Player {
    public static int speed = 10;
    public int id;

    ArrayList<String> list = new ArrayList<>();

    public Image image = new ImageIcon("/Player/Player.png").getImage();

    public Player() {
        list.add("Player/Player.png");
    }

}
