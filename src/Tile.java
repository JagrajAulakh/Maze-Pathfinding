import java.awt.*;

public class Tile {
	private boolean obstacle;

	private int x, y;

	public Tile(int x, int y) { this(x, y, false); }
	public Tile(int x, int y, boolean wall) {
		this.x = x;
		this.y = y;
		obstacle = wall;
	}

	public boolean isObstacle() { return obstacle; }
	public void toggleObstacle() { obstacle = !obstacle; }
	public void setObstacle(boolean v) { obstacle = v; }

	public void render(Graphics g) {
		if (obstacle) {
			g.setColor(Color.WHITE);
			g.fillRect(x+1, y+1, Grid.TILE_SIZE-2, Grid.TILE_SIZE-2);
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
