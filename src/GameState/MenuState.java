package GameState;

import TileMap.Background;
import Main.GamePanel;

import java.awt.*;
import java.awt.event.*;

public class MenuState extends GameState{

    private Background bg;

    private int currentChoice = 0;
    private String[] options = {
            "Start",
            "Controls",
            "Help",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;
        
        try{
            bg = new Background("/Backgrounds/menubg.gif", 1);
            bg.setVector(-0.1, 0);
            
            titleColor = new Color(128, 0, 0);
            titleFont = new Font("Century Gothic", Font.PLAIN, 28);
            
            font = new Font("Arial", Font.PLAIN, 12);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void init() {
    }
    public void update() {
        bg.update();
    }
    public void draw(java.awt.Graphics2D g) {
        // draw bg
        bg.draw(g);

        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Dragon Adventure", 30, 70);

        // draw menu options
        g.setFont(font);
        for(int i = 0; i < options.length; i++){
            if(i == currentChoice){
                g.setColor(Color.BLACK);
            }
            else{
                g.setColor(Color.RED);
            }
            g.drawString(options[i], 145, 140 + i * 15);
        }
    }

    private void select(){
        if(currentChoice == 0){
            gsm.setState(GameStateManager.LEVEL1STATE);
        }
        if(currentChoice == 1){
            // controls
        }
        if(currentChoice == 2){
            // help
        }
        if(currentChoice == 3){
            System.exit(0);
        }
    }

    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }
    public void keyReleased(int k) {
    }
    public void keyTyped(int k) {
    }

    public void mouseClicked(MouseEvent e) {
    }   
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) { 
        int x = e.getX();
        int y = e.getY();

        int SCALE = GamePanel.SCALE;
        
        if(x >= 145 * SCALE && x <= 145 * SCALE + 100 * SCALE){
            if(y >= 140 * SCALE-20 && y <= (140 * SCALE + 15 * SCALE)-20){
                gsm.setState(GameStateManager.LEVEL1STATE);
            }
            if(y >= 155 * SCALE-20 && y <= (155 * SCALE + 15 * SCALE)-20){
                // controls
            }
            if(y >= 170 * SCALE-20 && y <= (170 * SCALE + 15 * SCALE)-20){
                // help
            }
            if(y >= 185 * SCALE-20 && y <= (185 * SCALE + 15 * SCALE)-20){
                System.exit(0);
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseMoved(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        //System.out.println(mx+" "+my);

        int SCALE = GamePanel.SCALE;
        
        if(mx > 145 * SCALE && mx < 145 * SCALE + 100 * SCALE){
            if(my > 140 * SCALE-20 && my < (140 * SCALE + 15 * SCALE)-20){
                currentChoice = 0;
            }
            else if(my > 155 * SCALE-20 && my < (155 * SCALE + 15 * SCALE)-20){
                currentChoice = 1;
            }
            else if(my > 170 * SCALE-20 && my < (170 * SCALE + 15 * SCALE)-20){
                currentChoice = 2;
            }
            else if(my > 185 * SCALE-20 && my < (185 * SCALE + 15 * SCALE)-20){
                currentChoice = 3;
            }
        }
    }

}
