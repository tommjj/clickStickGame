package gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Game;
import utilz.Constants;
import utilz.Constants.GameConstants;

public class Menu extends State implements Statemethods {

    private int stickSet = 50;
    private boolean firstCheck = true;
    private int numberOffset = 10;

    public Menu(Game game) {
        super(game);
    }

    @Override
    public void update() {
        if (firstCheck) {
            game.getBackground().setValue(stickSet);
            firstCheck = false;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Enter to play!", GameConstants.GAME_WIDTH / 2, 150);
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

        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                game.getBackground().getNumberDisplay().chaneValue(-numberOffset);
                chaneStickSet(-numberOffset);
                break;
            case KeyEvent.VK_D:
                game.getBackground().getNumberDisplay().chaneValue(numberOffset);
                chaneStickSet(numberOffset);
                break;
            case KeyEvent.VK_SPACE:
                if(numberOffset == 1) {
                    numberOffset = 10;
                } else {
                    numberOffset = 1;
                }
                break;
            case KeyEvent.VK_ENTER:
                Gamestate.setState(Gamestate.PLAYING);
                resetBool();
                        
                game.getBackground().setValue(stickSet);
                game.getPlaying().createStick();
                break;
            default:

        }
    }

    public void chaneStickSet(int value) {
        stickSet += value;

        if (stickSet > 999) {
            stickSet = 999;
        } else if (stickSet < 0) {
            stickSet = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
    private void resetBool() {
        firstCheck = true;
        numberOffset = 10;
    }
}
