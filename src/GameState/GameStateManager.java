package GameState;

import java.util.ArrayList;
import java.awt.event.*;

public class GameStateManager {
    private ArrayList<GameState> gameStates;
    private int currentState;

    public static final int MENUSTATE = 0;
    public static final int LEVEL1STATE = 1;

    public GameStateManager() {
        gameStates = new ArrayList<GameState>();
        
        currentState = MENUSTATE;
        gameStates.add(new MenuState(this));
        gameStates.add(new Level1State(this));
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
    public void keyTyped(int k) {
        gameStates.get(currentState).keyTyped(k);
    }

    public void mouseClicked(MouseEvent e) {
        gameStates.get(currentState).mouseClicked(e);
    }
    public void mouseEntered(MouseEvent e) {
        gameStates.get(currentState).mouseEntered(e);
    }
    public void mouseExited(MouseEvent e) {
        gameStates.get(currentState).mouseExited(e);
    }
    public void mousePressed(MouseEvent e) {
        gameStates.get(currentState).mousePressed(e);
    }
    public void mouseReleased(MouseEvent e) {
        gameStates.get(currentState).mouseReleased(e);
    }
    public void mouseDragged(MouseEvent e) {
        gameStates.get(currentState).mouseDragged(e);
    }
    public void mouseMoved(MouseEvent e) {
        gameStates.get(currentState).mouseMoved(e);
    }

}
