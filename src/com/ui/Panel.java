package com.ui;

import com.Resources;

import java.awt.*;
import java.util.LinkedList;

public class Panel {

	private int x,y,width, height;
	private LinkedList<UIElement> elements;
	private TickButton showLinesButton;

	public Panel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		elements = new LinkedList<UIElement>();

		showLinesButton = new TickButton(x+20, y+50, "Show Grid Lines");
		elements.add(showLinesButton);
		RadioButton algsButton = new RadioButton(x+20, y+100);
		algsButton.addValue("A* Path-finding");
		algsButton.addValue("D* Path-finding");
		elements.add(algsButton);
	}

	public boolean showLines() { return showLinesButton.value(); }

	public void update() {
		for (UIElement e:elements) {
			e.update();
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect (x, y, width, height);

		g.setFont(Resources.font24);
		g.setColor(Color.GREEN);
		g.drawString("Control Panel",x+2,y+15);

		for (UIElement e:elements) {
			e.render(g);
		}
	}

}
