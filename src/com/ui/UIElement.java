package com.ui;

import java.awt.*;

public abstract class UIElement {

	protected int x, y;

	public UIElement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract void update();
	public abstract void render(Graphics g);
}
