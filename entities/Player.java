package dev.adiswami.finalproject.entities;

import java.awt.Graphics;

import dev.adiswami.finalproject.Game;
import dev.adiswami.finalproject.gfx.Assets;

public class Player extends Entity {

	private Game game;
	public static int d = 7;
	public Player(Game game,float x, float y, int width, int height)
	{
		super(x,y, width, height);
		this.game = game;
	}

	@Override
	public void tick() {
		if(game.getKeyer().left && getX()>=7) //if left
		{
			setX(getX() - d);
		}
		if(game.getKeyer().right && getX()<=796) //if right
		{
			setX(getX() + d);
		}
	}
	public void resetPosit()
	{
		setX(450);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
		
	}
}
