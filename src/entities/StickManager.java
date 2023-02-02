package entities;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
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
        for (Stick s : stickArr) {
            if (s.isActive()) {
                s.draw(g);
            }
        }
    }

    public void mouseClick(MouseEvent e) {
        int value = getIndex(e.getX(), e.getY());
        System.out.println("" + value);
        if (value >= 0) {
            if (checkTop(value)) {
                stickArr.get(value).setActive(false);
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
}
