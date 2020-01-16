import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.font.*;

public class Resources {

	public static BufferedImage sark;

	// Loads Resources
	public Resources() {
		try {
			sark = ImageIO.read(new File("sark.jpg"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
