package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utilz.LoadSave;

public class NumberDisplay {

    private int x, y;
    private int width, height;
    private BufferedImage[] numberImg;
    private int value;
    private int n1 = 0, n2 = 0, n3 = 0;

    public NumberDisplay(int x, int y, int width, int height, int value) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.value = value;
        loadImg();
    }

    public void loadImg() {
        BufferedImage temp = LoadSave.getSpriteAtlas(LoadSave.NUMBERS_IMG);

        numberImg = new BufferedImage[10];
        for (int i = 0; i < 10; i++) {
            numberImg[i] = temp.getSubimage(155 * i, 45, 155, 211);
        }

    }

    public void update() {
        if (value < 0) {
            value = 0;
        } else if (value > 999) {
            value = 999;
        }
        n1 = (int) (value / 100);
        n2 = (int) (value % 100) / 10;
        n3 = (int) value % 10;

    }

    public void draw(Graphics g) {
        g.drawImage(numberImg[n1], x, y, (width / 3), height, null);
        g.drawImage(numberImg[n2], x + (width / 3), y, (width / 3), height, null);
        g.drawImage(numberImg[n3], x + ((width / 3) * 2), y, (width / 3), height, null);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void chaneValue(int value) {
        this.value += value;
    }
}
