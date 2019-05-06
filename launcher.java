package dev.adiswami.finalproject;

import dev.adiswami.finalproject.display.Display;

public class Launcher {
	public static void main(String[] args)
	{
		Game game = new Game("FinalProj", 1000, 800);
		game.start();
	}
}
