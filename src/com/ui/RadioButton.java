package com.ui;

import com.Input;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class RadioButton extends UIElement {

	public static final int RADIUS = 10;

	private ArrayList<String> values;
	private int index;
	private int lineHeight;

	public RadioButton(int x, int y) {
		super(x, y);
		values = new ArrayList<>();
		index = 0;
		lineHeight = (int) Math.round(font.getStringBounds("gG", new FontRenderContext(null, false, false)).getHeight());
	}

	public void addValue(String val) {
		values.add(val);
	}

	public String currentValue() {
		return values.get(index);
	}

	public int getIndex() {
		return index;
	}

	@Override
	public void update() {
		int mx = Input.mx;
		int my = Input.my;

		if (Input.mouseUp(0)) {
			for (int i = 0; i < values.size(); i++) {
				Rectangle2D r = font.getStringBounds(values.get(i), new FontRenderContext(null, false, false));
				int width = (int) Math.round(r.getWidth());
				int height = (int) Math.round(r.getHeight());
				if (x <= mx && mx <= x + width + 20 && y + (lineHeight) * i + (i * 3) <= my && my <= y + (lineHeight) * (i + 1) + ((i + 1) * 3)) {
					index = i;
				}
			}
		}
	}

	@Override
	public void render(Graphics g) {
		Rectangle2D r = font.getStringBounds(values.get(0), new FontRenderContext(null, false, false));
		g.setColor(Color.WHITE);
		for (int i = 0; i < values.size(); i++) {
			int y = this.y + (lineHeight + 3) * i;
			// Draw circle
			if (i == index)
				g.fillOval(x, y + lineHeight / 2 - RADIUS / 2, RADIUS, RADIUS);
			else
				g.drawOval(x, y + lineHeight / 2 - RADIUS / 2, RADIUS, RADIUS);

			// Draw string
			g.drawString(values.get(i), x + 20, y + lineHeight * 3 / 4);
		}
	}
}
