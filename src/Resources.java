import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.font.*;

public class Resources {

	public static BufferedImage sark;
	public static Font font1;

	// Loads Resources
	public Resources() {
	}

	public static void load() throws IOException {
		sark = ImageIO.read(new File("sark.jpg"));
		font1 = new Font("Times New Roman", Font.PLAIN, 16);
	}

}
