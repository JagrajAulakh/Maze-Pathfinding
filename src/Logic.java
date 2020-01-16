import java.awt.*;
import java.awt.event.KeyEvent;

public class Logic {
	public Logic() {
		new Resources();
	}

	public void update() {
		if (Input.keyUpOnce(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);

		int mx = Input.mx;
		int my = Input.my;

		drawCentered(g, Resources.sark, mx, my);

	}

	public void drawCentered(Graphics g, Image img, int x, int y) {
		int cx = x - img.getWidth(null)/2;
		int cy = y - img.getHeight(null)/2;
		g.drawImage(img, cx, cy, null);
	}
}

