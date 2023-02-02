package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import static utilz.Constants.Entities.StickConstants.HORIZONTAL;
import static utilz.Constants.Entities.StickConstants.*;


public class Stick {
    private Rectangle stick;
    private Color color; 
    
    public Stick(int x, int y,Color color, int type) {
        stick = new Rectangle();
        color = color;
        
        stick.x = x;
        stick.y = y;
        this.color = color;
        if(type == HORIZONTAL) {
            stick.width = S_LENGTH_SIZE;
            stick.height = S_WIDTH_SIZE;      
        } else {
            stick.width = S_WIDTH_SIZE;
            stick.height = S_LENGTH_SIZE;     
        }
    }

    public Rectangle getStick() {
        return stick;
    }

    public Color getColor() {
        return color;
    }

    void draw(Graphics g) {       
        g.setColor(color);
        g.fillRect(stick.x, stick.y, stick.width, stick.height);
        
        g.setColor(Color.black);
        g.drawRect(stick.x, stick.y, stick.width, stick.height);
    }
    
    
    
}