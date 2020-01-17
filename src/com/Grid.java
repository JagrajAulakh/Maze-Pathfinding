package com;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Grid {
	public static final int TILE_SIZE = 10;

	private int twidth, theight;
	private Tile[][] grid;
	private boolean showLines;
	private boolean mazeMode;
	Tile start, end;
	private ArrayList<Tile> currentPath;

	private int x, y;

	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
		showLines = true;
		twidth = 600 / TILE_SIZE;
		theight = 600 / TILE_SIZE;

		grid = new Tile[twidth][theight];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = new Tile(x + TILE_SIZE * j, y + TILE_SIZE * i, false);
			}
		}
		start = grid[0][0];
		end = grid[0][0];
	}

	public void toggleLines() {
		showLines = !showLines;
	}

	public void setLines(boolean v) {
		showLines = v;
	}

	public ArrayList<Tile> A_Star(Tile start, Tile end) {

		ArrayList<Tile> open = new ArrayList<Tile>();
		ArrayList<Tile> closed = new ArrayList<Tile>();
		open.add(start);

		while (true) {
			Tile current = open.get(0);
			for (Tile t : open) {
				if (current.fCost > t.fCost) {
					current = t;
				}
			}

			ArrayList<Tile> neighbours = new ArrayList<Tile>();
			if (current.getXIndex() + 1 < grid[0].length) {
				neighbours.add(grid[current.getYIndex()][current.getXIndex() + 1])
				; // Right Node
			}
			if (current.getXIndex() - 1 > 0) {
				neighbours.add(grid[current.getYIndex()][current.getXIndex() - 1]); // Left Node
			}
			if (current.getYIndex() + 1 < grid.length) {
				neighbours.add(grid[current.getYIndex() + 1][current.getXIndex()]); // Top Node
			}
			if (current.getYIndex() - 1 > 0) {
				neighbours.add(grid[current.getYIndex() - 1][current.getXIndex()]); // Bottom Node
			}

			open.remove(current);
			closed.add(current);

			if (current == end) {
				break;
			}

			for (Tile n : neighbours) {
				if (n.isObstacle() || closed.contains(n)) {
					continue;
				}
				int newGCost = n.calculateGCost(current);
				int newHCost = n.calculateHCost(end);
				int newFCost = newGCost + newHCost;

				if (n.fCost == -1 || newFCost < n.fCost || !open.contains(n)) {
					n.setParent(current);
					n.setFCost(newFCost);
					if (!open.contains(n)) {
						open.add(n);
					}
				}
			}

		}

		ArrayList<Tile> path = new ArrayList<Tile>();
		Tile current = end;
		while (current.getParent() != null) {
			path.add(current);
			current = current.getParent();
		}
		path.add(start);
		return path;
	}

	public Tile tileFromMouse(int mx, int my) {
		int ix = -(x - mx) / TILE_SIZE;
		int iy = -(y - my) / TILE_SIZE;
		if (0 <= ix && ix < grid[0].length && 0 <= iy && iy < grid.length) {
			return grid[iy][ix];
		}
		return null;
	}

	public void update() {

		if (Input.keyDownOnce(KeyEvent.VK_M)) {
			mazeMode = !mazeMode;
		}
		if (Input.keyDownOnce(KeyEvent.VK_ENTER)) {
			currentPath = A_Star(start, end);
		}

		if (mazeMode) {
			if (Input.mousePressed(0) || Input.mousePressed(2)) {
				Tile t = tileFromMouse(Input.mx, Input.my);
				if (t != null) {
					t.setObstacle(Input.mousePressed(0));
				}
			}
		} else {
			if (Input.mouseDown(0)) {
				Tile newStart = tileFromMouse(Input.mx, Input.my);
				start = newStart == null ? start : newStart;
			}
			if (Input.mouseDown(2)) {
				Tile newEnd = tileFromMouse(Input.mx, Input.my);
				end = newEnd == null ? end : newEnd;
			}
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j].render(g);
			}
		}
		if (showLines) {
			g.setColor(new Color(0, 255, 0, 80));
			for (int i = 0; i <= twidth; i++) {
				g.drawLine(x + i * TILE_SIZE, y, x + i * TILE_SIZE, y + twidth * TILE_SIZE);
				g.drawLine(x, y + i * TILE_SIZE, x + twidth * TILE_SIZE, y + i * TILE_SIZE);
			}
		}

		if (currentPath != null) {
			g.setColor(Color.GREEN);
			for (Tile t:currentPath) {
				g.fillRect(t.getX() + 1, t.getY() + 1, TILE_SIZE-2, TILE_SIZE-2);
			}
		}

		// start/end circles
		final int SIZE = 10;
		g.setColor(new Color(190, 150, 50));
		if (start != null) {
			g.fillOval((int) start.getX(), (int) start.getY(), SIZE, SIZE);
		}
		if (end != null) {
			g.fillOval((int) end.getX(), (int) end.getY(), SIZE, SIZE);
		}
		// Mouse circle
		g.setColor(Color.RED);
		g.fillOval(Input.mx - SIZE / 2, Input.my - SIZE / 2, SIZE, SIZE);

		g.setFont(Resources.font16);
		g.setColor(mazeMode ? Color.RED : Color.GREEN);
		g.drawString("Mode: " + (mazeMode ? "Maze Draw" : "Point Placing"), 5, 25);
	}
}
