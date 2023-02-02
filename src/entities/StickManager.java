package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import static utilz.RandomMethods.*;

public class StickManager {
    private ArrayList<Stick> stickArr;

    public StickManager(int n) {            
        this.stickArr = new ArrayList<>();
        Stick temp;
        int type;  
        for (int i = 0; i < n; i++) {
            type = GetStickType();
            temp = new Stick(GetRandomX(type), GetRandomY(type), GetRandomColor(), type);
            stickArr.add(temp);
        }
    }
    
    public void update() {
        
    }
    
    public void draw(Graphics g) {
        for(Stick s: stickArr) {
            s.draw(g);
        }
    }
    
    
}
