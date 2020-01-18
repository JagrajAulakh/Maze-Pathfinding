package com;

import java.awt.*;

public class Tile {
	public static final int OPEN = 1;
	public static final int CLOSED = 2;

	private boolean obstacle;

	private int x, y;

	public int fCost, gCost, hCost;
	private Tile parent;

	public Tile(int x, int y) {
		this(x, y, false);
	}

	public Tile(int x, int y, boolean wall) {
		this.x = x;
		this.y = y;
		obstacle = wall;
		fCost = -1;
		gCost = -1;
		hCost = -1;
	}

	public boolean isObstacle() {
		return obstacle;
	}

	public void toggleObstacle() {
		obstacle = !obstacle;
	}

	public void setObstacle(boolean v) {
		obstacle = v;
	}

	public void render(Graphics g) {
		render(g, 0);
	}

	public void render(Graphics g, int status) {
		if (status > 0 || obstacle) {
			Color c = Color.BLACK;
			if (obstacle) c = Color.CYAN;
			if (status == OPEN) c = Color.GREEN;
			if (status == CLOSED) c = Color.RED;
			g.setColor(c);
			g.fillRect(x + 1, y + 1, Grid.TILE_SIZE - 2, Grid.TILE_SIZE - 2);
		}
	}

	public int getXIndex() {
		return x / Grid.TILE_SIZE;
	}

	public int getYIndex() {
		return y / Grid.TILE_SIZE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setParent(Tile p) {
		parent = p;
	}

	public Tile getParent() {
		return parent;
	}

	public int calculateGCost(Tile parent) {
		return parent.gCost + 1;
	}

	public int calculateHCost(Tile end) {
		return (int) Math.round(Math.hypot(x - end.x, y - end.y));
	}

	public void setFCost(int f) {
		fCost = f;
	}

}
