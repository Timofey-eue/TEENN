package Game;

import java.util.ArrayList;

public class GameStateManager {

    private final ArrayList<GameState> gameStates;

    private int currentState;

    public static final int MENUSTATE = 0;
    public static final int MAPSTATE = 1;
    public static final int ONLINE = 2;
    public static final int HELP = 3;


    public GameStateManager() {

        gameStates = new ArrayList<GameState>();

        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new GamePanel.MapState(this));
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState).init();
    }


    public void update() {
        gameStates.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g) {
        gameStates.get(currentState).draw(g);
    }

    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k) {
        gameStates.get(currentState).keyReleased(k);
    }

}

