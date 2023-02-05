package gameStates;

import entities.StickManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Game;
import ui.NumberDisplay;
import utilz.Constants.GameConstants;

public class Playing extends State implements Statemethods {

    private StickManager stickManager;
    
    
    public Playing(Game game) {
        super(game);
        stickManager = new StickManager(this);     
    }
    
    public void createStick() {
        stickManager.createSticks(game.getBackground().getNumberDisplay().getValue());
    }

    public StickManager getStickManager() {
        return stickManager;
    }

    @Override
    public void update() {
        game.getBackground().setValue(stickManager.getCurrentNumberOfStick());
        stickManager.update();
    }

    @Override
    public void draw(Graphics g) {
        
        
        stickManager.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        stickManager.mouseClick(e);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                Gamestate.setState(Gamestate.MENU);
                break;
            default:
        }
    }
}
