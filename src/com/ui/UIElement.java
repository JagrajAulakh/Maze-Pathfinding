package com.ui;

import com.Resources;

import java.awt.*;

public abstract class UIElement {

	protected int x, y;
	protected Font font;

	public UIElement(int x, int y) {
		this.x = x;
		this.y = y;
		font = Resources.font18;
	}

	public abstract void update();
	public abstract void render(Graphics g);
}
