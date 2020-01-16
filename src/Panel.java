import java.awt.*;

public class Panel {

    private int x,y,width, height;

    public Panel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update() {

    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect (x, y, width, height);

        g.setFont(Resources.font1);
        g.setColor(Color.GREEN);
        g.drawString("Control Panel",x+2,y+15);
    }

}
