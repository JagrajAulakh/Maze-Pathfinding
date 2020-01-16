import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameLoop extends Canvas {
	public static int WIDTH = 800;
	public static int HEIGHT = 600;
	public static final String TITLE = "Pathfinding";

	private Logic logic;
	private boolean running = true;

	private JFrame frame;

	public GameLoop() {
		frame = new JFrame();
		frame.setTitle(TITLE);
		Dimension d = new Dimension(WIDTH, HEIGHT);
		setSize(d);
		setMaximumSize(d);
		setMinimumSize(d);

		logic = new Logic();
		Input input = new Input();
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		addMouseWheelListener(input);
		setFocusable(true);        // These two lines allow
		requestFocusInWindow();    // the key listener to work

		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		run();
	}

	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				Input.update();
				Dimension d = frame.getSize();
				WIDTH = (int) d.getWidth();
				HEIGHT = (int) d.getHeight();
				tick();
				delta--;
			}

			if (running) {
				render();
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
	}

	private void tick() {
		logic.update();
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();

		logic.render(g);

		g.dispose();
		bs.show();
	}
}
