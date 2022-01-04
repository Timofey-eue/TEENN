package Game;

import TileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
        private Background bg;

        private int currentChoice = 0;
        private final String[] options = {
                "Start",
                "Online",
                "Help",
                "Quit"
        };

        private Color titleColor;
        private Font titleFont;

        private Font font;

        public MenuState(GameStateManager gsm) {
            this.gsm = gsm;
            try {
                bg = new Background("/Backgrounds/menubg1.png", 1);
                bg.setVector(0, 0);

                titleColor = new Color(0, 0, 0);
                titleFont = new Font(
                        "Thoma",
                        Font.PLAIN,
                        56);
                font = new Font("Arial", Font.PLAIN, 28);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        public void init() {}

        public void update() {
            bg.update();
        }

        public void draw(Graphics2D g) {

            bg.draw(g);

            g.setColor(titleColor);
            g.setFont(titleFont);
            g.drawString("Tennis Online", 180, 160);

            g.setFont(font);
            for(int i = 0; i < options.length; i++) {
                if(i == currentChoice) {
                    g.setColor(Color.BLACK);
                }
                else {
                    g.setColor(Color.RED);
                }
                g.drawString(options[i], 310, 245 + i * 30);
            }

        }

        private void select() {
            if(currentChoice == 0) {
                gsm.setState(GameStateManager.MAPSTATE);
            }
            if(currentChoice == 1) {
                //online
            }
            if(currentChoice == 2) {
                // help
            }
            if(currentChoice == 3) {
                System.exit(0);
            }
        }

        public void keyPressed(int k) {
            if(k == KeyEvent.VK_ENTER){
                select();
            }
            if(k == KeyEvent.VK_UP) {
                currentChoice--;
                if(currentChoice == -1) {
                    currentChoice = options.length - 1;
                }
            }
            if(k == KeyEvent.VK_DOWN) {
                currentChoice++;
                if(currentChoice == options.length) {
                    currentChoice = 0;
                }
            }
        }
        public void keyReleased(int k) {}

    }
