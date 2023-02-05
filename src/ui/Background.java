package ui;

import gameStates.Playing;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;
import utilz.Constants;
import utilz.Constants.GameConstants;
import utilz.Constants.UI.NumberDisplayContants;
import utilz.LoadSave;

public class Background {
    private NumberDisplay numberDisplay;
    private BufferedImage backgroundImg;
    private Game game;
        
    public Background(Game game) {
        this.game = game;
        loadImg();
        numberDisplay = new NumberDisplay((Constants.GameConstants.GAME_WIDTH - NumberDisplayContants.WIDTH_SIZE)-(int)(10 * GameConstants.SCALE), (Constants.GameConstants.GAME_HEIGHT / 2)-(NumberDisplayContants.HEIGHT_SIZE/2),NumberDisplayContants.WIDTH_SIZE,NumberDisplayContants.HEIGHT_SIZE , 50);
    }
    
    public void loadImg() {
        backgroundImg = LoadSave.getSpriteAtlas(LoadSave.BACKGROUND_IMG);
    }
    
    public void setValue(int value) {
        numberDisplay.setValue(value);
    }
    
    public void update() {
        numberDisplay.update();
    }
    
    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, Constants.GameConstants.GAME_WIDTH, Constants.GameConstants.GAME_HEIGHT, null);
        
        numberDisplay.draw(g);
    }

    public NumberDisplay getNumberDisplay() {
        return numberDisplay;
    }
    
    public int getValue() {
        return numberDisplay.getValue();
    }
}
