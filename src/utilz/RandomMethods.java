package utilz;

import java.awt.Color;
import java.util.Random;
import static utilz.Constants.Entities.StickConstants.HORIZONTAL;
import static utilz.Constants.Entities.StickConstants.*;
import static utilz.Constants.GameConstants.*;

public class RandomMethods {
    public static Random rd = new Random();
    
    public static Color GetRandomColor() {
        int r = rd.nextInt(255);
        int g = rd.nextInt(255);
        int b = rd.nextInt(255);
        return new Color(r, g, b);
    } 
    
    public static int GetRandomX(int Type) {
        if(Type == HORIZONTAL) {
            return rd.nextInt(GAME_WIDTH - S_LENGTH_SIZE);
        } else {
            return rd.nextInt(GAME_WIDTH - S_WIDTH_SIZE);
        }
    }
    
    public static int GetRandomY(int Type) {
        if(Type == HORIZONTAL) {
            return rd.nextInt(GAME_HEIGHT - S_WIDTH_SIZE);
        } else {
            return rd.nextInt(GAME_HEIGHT - S_LENGTH_SIZE);
        }
    }
    
    public static int GetStickType() {
        return rd.nextInt(2);
    }
}
