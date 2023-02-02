package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.GamePanel;

public class MouseInputs implements MouseListener{
    GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        gamePanel.getGame().getStickManager().mouseClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }
        
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
