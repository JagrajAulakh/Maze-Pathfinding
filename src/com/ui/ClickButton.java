package com.ui;

import com.Input;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class ClickButton extends UIElement {

    private String value;
    private Rectangle2D textRect;
    private boolean active;

    public ClickButton(int x, int y, String value) {
        super(x,y);
        active = false;
        this.value = value;
        textRect = font.getStringBounds(value, new FontRenderContext(null, false, false));
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public void update() {
        int mx = Input.mx;
        int my = Input.my;
        if (Input.mouseUp(0)) {
            active = x < mx && mx <= x + textRect.getWidth() + 20 && y < my && my <= y + textRect.getHeight();
        }
    }

    @Override
    public void render(Graphics g) {
        final int BOX_SIZE = 75;

        g.setColor(Color.GREEN);
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE/2);
        g.setFont(font);
        g.drawString(value, x+6, y+BOX_SIZE/2-BOX_SIZE/6);
    }

}
