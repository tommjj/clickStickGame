package gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import main.Game;
import ui.MenuButtons;
import utilz.Constants.UI.MenuButtonsContants;

public class Menu extends State implements Statemethods {

    private int stickSet = 50;
    private boolean firstCheck = true;
    private int plusValue = 10;
    private MenuButtons playButton, quitButton, OptionsButton, plusButton, minusButton;

    private boolean plusCheck = false, minusCheck = false;
    private int maxSpeed = 10, currentSpeed = 10, minSpeed = 1, tick = 0;

    public Menu(Game game) {
        super(game);
        initMenuButtons();
    }

    private void initMenuButtons() {
        playButton = new MenuButtons(940, 530, MenuButtonsContants.WIDTH_SIZE, MenuButtonsContants.HEIGHT_SIZE, 0, -5);
        quitButton = new MenuButtons(-350, 530, MenuButtonsContants.WIDTH_SIZE, MenuButtonsContants.HEIGHT_SIZE, 1, 5);
        OptionsButton = new MenuButtons(-100, 530, MenuButtonsContants.WIDTH_SIZE, MenuButtonsContants.HEIGHT_SIZE, 2, 5);
        plusButton = new MenuButtons(940 - 80, 530, MenuButtonsContants.WIDTH_SIZE, MenuButtonsContants.HEIGHT_SIZE, 3, -5);
        minusButton = new MenuButtons(940 - 80 - 80 - 80, 530, MenuButtonsContants.WIDTH_SIZE, MenuButtonsContants.HEIGHT_SIZE, 4, -5);
        playButton.setShadowOffsetX(0);
        playButton.setDrawShadowCheck(true);
        quitButton.setDrawShadowCheck(false);
        OptionsButton.setDrawShadowCheck(true);
        plusButton.setDrawShadowCheck(false);
    }

    @Override
    public void update() {
        if (firstCheck) {
            game.getBackground().setValue(stickSet);
            firstCheck = false;
        }

        if (plusCheck) {
            tick++;
            if (tick > currentSpeed) {
                game.getBackground().getNumberDisplay().chaneValue(plusValue);
                chaneStickSet(plusValue);
                tick = 0;        
                if(currentSpeed > minSpeed) {
                    currentSpeed--;
                }
            }

        } else if (minusCheck) {
             tick++;
            if (tick > currentSpeed) {
                game.getBackground().getNumberDisplay().chaneValue(-plusValue);
                chaneStickSet(-plusValue);
                tick = 0;
                if(currentSpeed > minSpeed) {
                    currentSpeed--;
                }
            }
        } else {
            tick = 0;
            currentSpeed = maxSpeed;
        }
        minusButton.update();
        plusButton.update();
        playButton.update();
        OptionsButton.update();
        quitButton.update();
    }

    @Override
    public void draw(Graphics g) {
        minusButton.draw(g);
        plusButton.draw(g);
        playButton.draw(g);
        OptionsButton.draw(g);
        quitButton.draw(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isIn(e, playButton)) {
            playButton.setMousePressed(true);
        } else if (isIn(e, quitButton)) {
            quitButton.setMousePressed(true);
        } else if (isIn(e, OptionsButton)) {
            OptionsButton.setMousePressed(true);
        } else if (isIn(e, plusButton)) {
            plusButton.setMousePressed(true);
            plusCheck = true;
        } else if (isIn(e, minusButton)) {
            minusButton.setMousePressed(true);
            minusCheck = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (isIn(e, playButton)) {
            if (playButton.isMousePressed()) {
                Gamestate.setState(Gamestate.PLAYING);
                resetBool();

                game.getBackground().setValue(stickSet);
                game.getPlaying().createStick();
            }
        } else if (isIn(e, quitButton)) {
            if (quitButton.isMousePressed()) {
                System.exit(0);
            }
        } else if (isIn(e, OptionsButton)) {
            if (OptionsButton.isMousePressed()) {
                System.out.println("options");
            }
        } else if (isIn(e, plusButton)) {
            if (plusButton.isMousePressed()) {
                plusCheck = false;
            }
        } else if (isIn(e, minusButton)) {
            if (minusButton.isMousePressed()) {
                minusCheck = false;
            }
        }
        plusCheck = false;
        minusCheck = false;
        playButton.resetBools();
        quitButton.resetBools();
        OptionsButton.resetBools();
        plusButton.resetBools();
        minusButton.resetBools();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        playButton.setMouseOver(false);
        quitButton.setMouseOver(false);
        OptionsButton.setMouseOver(false);
        plusButton.setMouseOver(false);
        minusButton.setMouseOver(false);

        if (isIn(e, playButton)) {
            playButton.setMouseOver(true);
        } else if (isIn(e, quitButton)) {
            quitButton.setMouseOver(true);
        } else if (isIn(e, OptionsButton)) {
            OptionsButton.setMouseOver(true);
        } else if (isIn(e, plusButton)) {
            plusButton.setMouseOver(true);
        } else if (isIn(e, minusButton)) {
            minusButton.setMouseOver(true);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                game.getBackground().getNumberDisplay().chaneValue(-plusValue);
                chaneStickSet(-plusValue);
                break;
            case KeyEvent.VK_D:
                game.getBackground().getNumberDisplay().chaneValue(plusValue);
                chaneStickSet(plusValue);
                break;
            case KeyEvent.VK_SPACE:
                if (plusValue == 1) {
                    plusValue = 10;
                } else {
                    plusValue = 1;
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
        plusValue = 10;
    }

    public boolean isIn(MouseEvent e, MenuButtons mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }
}
