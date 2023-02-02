package main;

import Inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import utilz.Constants.GameConstants;

public class GamePanel extends JPanel{
    private Game game;
    private MouseInputs mouseInputs;
    
    public GamePanel(Game game) {
        this.game = game;
        mouseInputs = new MouseInputs(this);
        setPanelSize();
        
        addMouseListener(mouseInputs);
        
    }    
    
    private void setPanelSize() {
        Dimension size = new Dimension(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        setPreferredSize(size);       
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.rander(g);
    }
    
}
