package dev.adiswami.finalproject.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage player;
	public static BufferedImage ball;
	public static BufferedImage gbrick;
	public static BufferedImage ybrick;
	public static BufferedImage rbrick;
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/images/sprite.png"));
		player = sheet.crop(25, 64, 120, 25);
		ball = ImageLoader.loadImage("/images/beach.png");
		gbrick= ImageLoader.loadImage("/images/greenrect.png");
		rbrick = ImageLoader.loadImage("/images/redrect.png");
		ybrick = ImageLoader.loadImage("/images/yellowrect.png");
	}
}
