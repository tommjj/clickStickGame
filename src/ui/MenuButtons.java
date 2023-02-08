package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import utilz.LoadSave;

public class MenuButtons extends Button {

    private BufferedImage buttonImg;
    private int type;
    private boolean mouseOver, mousePressed;
    private int offsetX, currentOffsetX;
    
    private boolean drawShadowCheck = true;
    private int shadowOffsetX = -4, shadowOffsetY = 4;

    public MenuButtons(int x, int y, int width, int height, int type, int offsetX) {
        super(x, y, width, height);
        this.type = type;
        this.offsetX = offsetX;
        initImage(type);
    }

    private void initImage(int type) {
        BufferedImage temp = LoadSave.getSpriteAtlas(LoadSave.MENU_BUTTON_IMG);
        buttonImg = temp.getSubimage(0, 146 * type, 500, 146);
    }

    public void update() {
        if (mouseOver) {
            currentOffsetX = offsetX;
        } else {
            currentOffsetX = 0;
        } 

        updateXBounds(currentOffsetX);
    }

    private void updateXBounds(int value) {
        bounds.x = x + value;
    }

    public void draw(Graphics g) {
        if (drawShadowCheck) {
            g.setColor(new Color(0, 0, 0, 130));
            g.fillRect(bounds.x + shadowOffsetX, bounds.y + shadowOffsetY, width, height);
        }

        g.drawImage(buttonImg, bounds.x, bounds.y, width, height, null);

        if (mousePressed) {
            g.setColor(new Color(0, 0, 0, 100));
            g.fillRect(bounds.x, bounds.y, width, height);
        } else if(mouseOver) {
            g.setColor(new Color(0, 0, 0, 70));
            g.fillRect(bounds.x, bounds.y, width, height);
        }
    }

    public boolean isMouseOver() {
        return mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setDrawShadowCheck(boolean drawShadowCheck) {
        this.drawShadowCheck = drawShadowCheck;
    }

    public void setShadowOffsetX(int shadowOffsetX) {
        this.shadowOffsetX = shadowOffsetX;
    }

    public void setShadowOffsetY(int shadowOffsetY) {
        this.shadowOffsetY = shadowOffsetY;
    }
    
    public void setShadowOffset(int shadowOffsetX, int shadowOffsetY) {
        this.shadowOffsetX = shadowOffsetX;
        this.shadowOffsetY = shadowOffsetY;
    }

    public void resetBools() {
        mouseOver = false;
        mousePressed = false;
    }
}
