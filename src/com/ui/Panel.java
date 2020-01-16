package com.ui;

import com.Resources;

import java.awt.*;
import java.util.LinkedList;

public class Panel {

	private int x,y,width, height;
	private LinkedList<UIElement> elements;

	public Panel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		elements = new LinkedList<UIElement>();
	}

	public void update() {
		for (UIElement e:elements) {
			e.update();
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect (x, y, width, height);

		g.setFont(Resources.font1);
		g.setColor(Color.GREEN);
		g.drawString("Control Panel",x+2,y+15);

		for (UIElement e:elements) {
			e.render(g);
		}
	}

}
