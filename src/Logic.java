import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Logic {

	private Grid grid;

	public Logic() {
		try {
			Resources.load();
		} catch (IOException e) {
			System.out.println("RESOURCES DIDN'T LOAD CORRECTLY");
			e.printStackTrace();
		}
		grid = new Grid(0, 0);
	}

	public void update() {
		if (Input.keyUpOnce(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}

		grid.update();
	}

	public void render(Graphics g) {
		g.setColor(new Color(15, 15, 15));
		g.fillRect(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);

		grid.render(g);

	}
}

