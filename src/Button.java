import java.awt.*;

public class Button {

    private int x,y,width,height,type;

    public static final int RADIO = 0;
    public static final int TICK = 1;

    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {

    }
}
