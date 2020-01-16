import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.font.*;

public class Resources {

    public static BufferedImage img1;

    // Loads Resources
    public Resources() {
        try {
            img1 = ImageIO.read(new File("sark.jpg"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
