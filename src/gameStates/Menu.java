package gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Game;
import utilz.Constants;
import utilz.Constants.GameConstants;

public class Menu extends State implements Statemethods{

    public Menu(Game game) {
        super(game);
    }
    
    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Enter to play!", GameConstants.GAME_WIDTH/2, 150);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       Gamestate.setState(Gamestate.PLAYING);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
