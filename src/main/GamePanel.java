package main;

import Inputs.KeybroandInputs;
import Inputs.MouseInputs;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import utilz.Constants.GameConstants;

public class GamePanel extends JPanel{
    private Game game;
    private MouseInputs mouseInputs;
    private KeybroandInputs keybroandInputs;
    
    public GamePanel(Game game) {
        this.game = game;
        mouseInputs = new MouseInputs(this);
        keybroandInputs = new KeybroandInputs(this);
        setPanelSize();
        
        addMouseListener(mouseInputs);
        addKeyListener(keybroandInputs);
    } 

    public Game getGame() {
        return game;
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
