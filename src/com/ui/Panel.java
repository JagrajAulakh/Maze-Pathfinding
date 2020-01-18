package com.ui;

import com.Resources;

import java.awt.*;
import java.util.LinkedList;

public class Panel {

	private int x,y,width, height;
	private LinkedList<UIElement> elements;
	private TickButton showLinesButton;
	private ClickButton calculateButton;
	private ClickButton resetButton;

	public Panel(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		elements = new LinkedList<UIElement>();

		showLinesButton = new TickButton(x+20, y+50, "Show Grid Lines");
		RadioButton algsButton = new RadioButton(x+20, y+100);
		calculateButton = new ClickButton(x+110,y+550,"Pathfind");
		resetButton = new ClickButton(x+30,y+550,"Refresh");

		algsButton.addValue("A* Path-finding");
		algsButton.addValue("D* Path-finding");

		elements.add(showLinesButton);
		elements.add(algsButton);
		elements.add(calculateButton);
		elements.add(resetButton);
	}

	public boolean showLines() { return showLinesButton.value(); }

	public boolean calculate() {
		return calculateButton.isActive();
	}

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
		g.drawString("Control Panel",x+2,y+18);

		for (UIElement e:elements) {
			e.render(g);
		}
	}

}
