package com;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.font.*;

public class Resources {

	public static BufferedImage sark;
	public static Font font16, font18, font24;

	// Loads com.Resources
	public Resources() {
	}

	public static void load() throws IOException {
		sark = ImageIO.read(new File("assets/sark.jpg"));
		font16 = new Font("Times New Roman", Font.PLAIN, 16);
		font18 = new Font("Times New Roman", Font.PLAIN, 18);
		font24 = new Font("Times New Roman", Font.PLAIN, 24);
	}

	// Drawing helper methods
	public static void drawCentered(Graphics g, Image img, int x, int y) {
		int cx = x - img.getWidth(null) / 2;
		int cy = y - img.getHeight(null) / 2;
		g.drawImage(img, cx, cy, null);
	}

	public static void drawArrow(Graphics g, Point p1, Point p2) {
		drawArrow(g, p1, p2, 20);
	}

	public static void drawArrow(Graphics g, Point p1, Point p2, int headSize) {
		drawArrow(g, p1.getX(), p1.getY(), p2.getX(), p2.getY(), headSize);
	}

	public static void drawArrow(Graphics g, double x1, double y1, double x2, double y2) {
		drawArrow(g, x1, y1, x2, y2, 20);
	}

	public static void drawArrow(Graphics g, double x1, double y1, double x2, double y2, int headSize) {
		double angle = Math.atan2(y2 - y1, x2 - x1);
		g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
		g.drawLine((int) x2, (int) y2, (int) (x2 + headSize * Math.cos(angle - Math.toRadians(180 + 30))), (int) (y2 + headSize * Math.sin(angle - Math.toRadians(180 + 30))));
		g.drawLine((int) x2, (int) y2, (int) (x2 + headSize * Math.cos(angle - Math.toRadians(180 - 30))), (int) (y2 + headSize * Math.sin(angle - Math.toRadians(180 - 30))));
	}
}
