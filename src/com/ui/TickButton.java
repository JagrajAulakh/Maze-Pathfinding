package com.ui;

import com.Input;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class TickButton extends UIElement {

	private String value;
	private Rectangle2D boxRect, textRect;
	private int lineHeight;
	private boolean ticked;

	public TickButton(int x, int y, String value) {
		super(x, y);
		this.value = value;
		ticked = false;
		textRect = font.getStringBounds(value, new FontRenderContext(null, false, false));
		lineHeight = (int)Math.round(textRect.getHeight());
	}

	public boolean value() { return ticked; }

	@Override
	public void update() {
		int mx = Input.mx;
		int my = Input.my;
		if (Input.mouseUp(0)) {
			if (x < mx && mx <= x + textRect.getWidth()+20 && y < my && my <= y + textRect.getHeight()) {
				ticked = !ticked;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		final int BOX_SIZE = 10;

		if (ticked) {
			g.drawLine(x, y + lineHeight / 2 - BOX_SIZE/2, x + BOX_SIZE, y + lineHeight / 2 + BOX_SIZE/2);
			g.drawLine(x + BOX_SIZE, y + lineHeight / 2 - BOX_SIZE/2, x, y + lineHeight / 2 + BOX_SIZE/2);
		}
		g.setColor(Color.WHITE);
		g.drawRect(x, y + lineHeight / 2 - BOX_SIZE/2, BOX_SIZE, BOX_SIZE);
		g.setFont(font);
		g.drawString(value, x + 20, y + lineHeight*3/4);
	}

}
