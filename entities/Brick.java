package dev.adiswami.finalproject.entities;

import java.awt.Color;
import java.awt.Graphics;

import dev.adiswami.finalproject.gfx.Assets;

public class Brick extends Entity{

	private boolean disappear = false;
	private Ball ball;
	private Color color;
	public Brick(Color color, Ball ball,double x, double y, int width, int height) {
		super(x, y, width, height);
		this.ball = ball;
		this.color= color;
	}


	@Override
	public void tick() {
		/*if(ball.getRect((int)ball.getX(), (int)ball.getY(), ball.getWidth(), ball.getHeight()).intersects(getRect((int)getX(), (int)getY(), getWidth(), getHeight())))
			setDisappear(true);*/
	}
	public void setDisappear(boolean bool){disappear = bool;}
	public boolean getDisappear(){return disappear;}

	@Override
	public void render(Graphics g) {
		if(!(getDisappear()))
		{
			/*int rand = (int)(Math.random()*3)+1;
			switch(rand)
			{
				case 1: g.drawImage(Assets.rbrick, (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
						break;
				case 2: g.drawImage(Assets.gbrick, (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
						break;
				case 3: g.drawImage(Assets.ybrick, (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
						break;
			}*/
			g.drawImage(Assets.rbrick,(int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(), null);
			g.setColor(color);
			g.fillRect((int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight());
		}
	}

}
