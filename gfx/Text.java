package dev.adiswami.finalproject.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text {
	public static void drawString(Graphics g, String text, int x, int y, Color c, Font font)
	{
		g.setColor(c);
		g.setFont(font);
		g.drawString(text, x, y);
	}
}
