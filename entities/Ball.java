package dev.adiswami.finalproject.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import dev.adiswami.finalproject.Game;
import dev.adiswami.finalproject.gfx.Assets;
import dev.adiswami.finalproject.sounds.Sound;
import dev.adiswami.finalproject.states.GameState;
import javafx.scene.media.AudioClip;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Ball extends Entity{

	private Game game;
	private int changeY =-5;
	private int changeX = -5;
	private int count =0;
	private Player player;
	public static int points =0;
	public static int lives = 3;
	public static int increase = 1;
	ArrayList<Entity> bricks = new ArrayList<>();
	public Ball(ArrayList<Entity> bricks,Player player, Game game, double x, double y, int width, int height) {
		super(x, y, width, height);
		this.game = game;
		this.player=player;
		this.bricks = bricks;
	}

	@Override
	public void tick() {
		if(getX()<=10)
			changeX*=-1;
		if(getY()<=50)
			changeY*=-1;
		if(getX()>=985)
			changeX*=-1;
		if(getY()>player.getY())
		{
			resetPos();
			player.resetPosit();
			lives--;
			increase = 1;
			player.d = 7;
			changeX = -5;
			changeY = -5;
		}
		if(player.getRect((int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight()).intersects(getRect((int)getX(), (int)getY(), getWidth(), getHeight())) && count!=0)
		{
			Sound.brickHit.play();
			if((getX() >= player.getX() && changeX>0 && getX()<=player.getX()+50) || (getX() <= player.getX()+player.getWidth() && getX()>=player.getX()+150 && changeX<0))
			{
				
				changeX*=-1;
			}
			changeY*=-1;
		}
		for(int k =0;k<bricks.size();k++)
		{
			if(getRect((int)getX(), (int)getY(), getWidth(), getHeight()).intersects(bricks.get(k).getRect((int)bricks.get(k).getX(), (int)bricks.get(k).getY(), bricks.get(k).getWidth(), bricks.get(k).getHeight())))
			{
				
				if((getX() <= bricks.get(k).getX() || getX() >= bricks.get(k).getX()+bricks.get(k).getWidth()) && (getY()!=bricks.get(k).getY() && getY() != (bricks.get(k).getY()+bricks.get(k).getHeight())))
					changeX*=-1;
				else changeY*=-1;
				if(bricks.get(k) instanceof RandBrick)
				{
					increase *= 2;
					changeX *= 2;
					changeY  *= 2;
					player.d *=2;
				}
				//changeY*=-1;
				bricks.remove(k);
				count++;
				points+=increase;
				Sound.bounce.play();
			}
		}
		setY(getY()+changeY);
		if(count!=0)
			setX(getX()+changeX);
	}
	public void resetPos() {
		// TODO Auto-generated method stub
		setX(495);
		setY(680);
		
	}
	public void setCount(int k){count = k;}
	public int getPoints(){return points;}
	public void setChangeY(int k){changeY = k;}
	public void setChangeX(int k){changeX = k;}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.ball, (int)super.getX(), (int)super.getY(), super.getWidth(), super.getHeight(),null);
		
	}

}
