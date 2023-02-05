package entities;

import gameStates.Gamestate;
import gameStates.Playing;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import static utilz.RandomMethods.*;

public class StickManager {
    private Playing playing;
    private ArrayList<Stick> stickArr;
    private int numberOfStick;
    private int currentNumberOfStick;

    public StickManager(Playing playing) {
        this.stickArr = new ArrayList<>();
        this.playing = playing;
    }

    public void createSticks(int value) {
        if (stickArr.size() > 0) {
            stickArr.removeAll(stickArr);
        }
        
        numberOfStick = value;
        currentNumberOfStick = numberOfStick;
        
        Stick temp;
        int type;
        for (int i = 0; i < value; i++) {
            type = GetStickType();
            temp = new Stick(GetRandomX(type), GetRandomY(type), GetRandomColor(), type);
            stickArr.add(temp);
        }
    }

    public void update() {
        
    }

    public void draw(Graphics g) {
        int count = 0;
        for (Stick s : stickArr) {
            if (s.isActive()) {
                s.draw(g);
                count++;
            }
        }
        if(count == 0) {
            Gamestate.setState(Gamestate.MENU);
            createSticks(numberOfStick);
        }       
    }
    
    

    public void mouseClick(MouseEvent e) {
        int value = getIndex(e.getX(), e.getY());
        System.out.println("" + value);
        if (value >= 0) {
            if (checkTop(value)) {
                stickArr.get(value).setActive(false);
                currentNumberOfStick--;
            }
        }
    }

    public int getIndex(int x, int y) {
        for (int i = stickArr.size() - 1; i >= 0; i--) {
            if (stickArr.get(i).isActive()) {
                if (stickArr.get(i).getStick().contains(x, y)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean checkTop(int index) {
        for (int i = index + 1; i < stickArr.size(); i++) {
            if (stickArr.get(i).isActive()) {
                if (stickArr.get(index).getStick().intersects(stickArr.get(i).getStick())) {
                    return false;
                }
            }

        }
        return true;
    }

    public int getCurrentNumberOfStick() {
        return currentNumberOfStick;
    }
    
    
}
