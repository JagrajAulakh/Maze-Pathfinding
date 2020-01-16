import java.awt.*;
import java.awt.event.KeyEvent;

public class Logic {
	public Logic() {

	}

	public void update() {
		if (Input.keyUpOnce(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);
	}
}
