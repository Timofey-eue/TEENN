package TileMap;

import Main.GameVisible;

import java.awt.*;
import java.awt.image.*;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Background {

    private BufferedImage image;

    private double x;
    private double y;
    private double dx;
    private double dy;

    private double moveScale;

    public Background(String s, double ms) {

        try {
            image = ImageIO.read(
                    Objects.requireNonNull(getClass().getResourceAsStream(s))
            );
            moveScale = ms;
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public Background(String s) {

        try {
            image = ImageIO.read(
                    Objects.requireNonNull(getClass().getResourceAsStream(s))
            );
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }


    public void setPosition(double x, double y) {
        this.x = (x * moveScale) % GameVisible.WIDTH;
        this.y = (y * moveScale) % GameVisible.HEIGHT;
    }

    public void setVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void update() {
        x += dx;
        y += dy;
    }

    public void draw(Graphics2D g) {

        g.drawImage(image, (int)x, (int)y, null);

        if(x < 0) {
            g.drawImage(
                    image,
                    (int)x + GameVisible.WIDTH,
                    (int)y,
                    null
            );
        }
        if(x > 0) {
            g.drawImage(
                    image,
                    (int)x - GameVisible.WIDTH,
                    (int)y,
                    null
            );
        }
    }

}







