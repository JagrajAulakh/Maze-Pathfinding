import java.awt.*;

public class Tile {
	private boolean obstacle;

	public Tile(boolean wall) {
		obstacle = wall;
	}

	public boolean isObstacle() { return obstacle; }

	public void render(Graphics g) {
	}
}
