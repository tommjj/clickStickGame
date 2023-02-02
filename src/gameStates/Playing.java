package gameStates;

import entities.StickManager;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Game;

public class Playing extends State implements Statemethods {

    private StickManager stickManager;

    public Playing(Game game) {
        super(game);
        stickManager = new StickManager(this);
        stickManager.createSticks(25);
    }

    public StickManager getStickManager() {
        return stickManager;
    }

    @Override
    public void update() {
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

    }

}
