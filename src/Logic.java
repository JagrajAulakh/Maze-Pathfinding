import java.awt.*;
import java.awt.event.KeyEvent;

public class Logic {

	Point start, end;

	public Logic() {
		new Resources();
		start = new Point(0, 0);
		end = new Point(0, 0);
	}

	public void update() {
		if (Input.keyUpOnce(KeyEvent.VK_ESCAPE)) {
			System.exit(0);
		}

		if (Input.mouseDown(0)) {
			start.setLocation(Input.mx, Input.my);
			System.out.println("start: " + Integer.toString((int) start.getX()) + ", " + Integer.toString((int) start.getY()));
		}
		if (Input.mouseDown(2)) {
			end.setLocation(Input.mx, Input.my);
		}

	}

	public void render(Graphics g) {
		int SIZE = 10;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameLoop.WIDTH, GameLoop.HEIGHT);

		// start/end circles
		g.setColor(Color.BLUE);
		drawArrow(g, start, end, 20);
		g.setColor(new Color(180, 30, 30));
		g.fillOval((int) start.getX() - SIZE / 2, (int) start.getY() - SIZE / 2, SIZE, SIZE);
		g.fillOval((int) end.getX() - SIZE / 2, (int) end.getY() - SIZE / 2, SIZE, SIZE);

		// Mouse circle
		g.setColor(Color.RED);
		g.fillOval(Input.mx - SIZE / 2, Input.my - SIZE / 2, SIZE, SIZE);
	}

	public void drawCentered(Graphics g, Image img, int x, int y) {
		int cx = x - img.getWidth(null) / 2;
		int cy = y - img.getHeight(null) / 2;
		g.drawImage(img, cx, cy, null);
	}

	public void drawArrow(Graphics g, Point p1, Point p2) {
		drawArrow(g, p1, p2, 20);
	}

	public void drawArrow(Graphics g, Point p1, Point p2, int headSize) {
		drawArrow(g, p1.getX(), p1.getY(), p2.getX(), p2.getY(), headSize);
	}

	public void drawArrow(Graphics g, double x1, double y1, double x2, double y2) {
		drawArrow(g, x1, y1, x2, y2, 20);
	}

	public void drawArrow(Graphics g, double x1, double y1, double x2, double y2, int headSize) {
		double angle = Math.atan2(y2 - y1, x2 - x1);
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
		g.drawLine((int) x2, (int) y2, (int) (x2 + headSize * Math.cos(angle - Math.toRadians(180 + 30))), (int) (y2 + headSize * Math.sin(angle - Math.toRadians(180 + 30))));
		g.drawLine((int) x2, (int) y2, (int) (x2 + headSize * Math.cos(angle - Math.toRadians(180 - 30))), (int) (y2 + headSize * Math.sin(angle - Math.toRadians(180 - 30))));
	}
}

