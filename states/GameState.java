package dev.adiswami.finalproject.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.adiswami.finalproject.Game;
import dev.adiswami.finalproject.entities.Ball;
import dev.adiswami.finalproject.entities.Brick;
import dev.adiswami.finalproject.entities.Entity;
import dev.adiswami.finalproject.entities.Player;
import dev.adiswami.finalproject.entities.RandBrick;
import dev.adiswami.finalproject.gfx.Assets;
import dev.adiswami.finalproject.gfx.Text;
import dev.adiswami.finalproject.sounds.Sound;

public class GameState extends State{
	private Player player;
	private Ball ball;
	private Game game;
	private MenuState menuState;
	private int highscore=0;
	private ArrayList<Entity> bricks = new ArrayList<Entity>();
	public GameState(Game game)
	{
		super(game);
		this.game = game;
		player = new Player(game, 450,710, 200, 20);
		ball = new Ball(bricks, player, game, 495, 680, 30, 30);
		 brickSet();
	}
	@Override
	public void tick() {
		if(ball.lives>0 && bricks.size()>0)
		{
			player.tick();
			ball.tick();
			for(int x=0;x<bricks.size();x++)
				bricks.get(x).tick();
		}
	}

	@Override
	public void render(Graphics g) {
		if(ball.lives>0 && bricks.size()>0)
		{
			g.setColor(new Color(100, 230, 86));
			g.fillRect(0, 0, 1000, 50);
			player.render(g);
			ball.render(g);
			for(int x=0;x<bricks.size();x++)
				bricks.get(x).render(g);
			Text.drawString(g, "Points:"+ball.getPoints(), 395, 40, Color.MAGENTA, new Font("Lucida Sans Unicode", Font.BOLD, 50));
			g.fillRect(0, 50, 1000, 3);

		}
		else if(game.getKeyer().spacebar)
		{
			//g.setColor(Color.BLACK);
			//g.fillRect(0, 0, 1000, 800);
			brickClear();
			brickSet();
			ball.resetPos();
			player.resetPosit();
			ball.setCount(0);
			ball.lives = 3;
			ball.points =0;
			ball.increase = 1;
			ball.setChangeX(-5);
			ball.setChangeY(-5);
			
		}
		else
			{
				Text.drawString(g, "GAME OVER!", 350, 100, Color.WHITE, new Font("Lucida Sans Unicode", Font.BOLD, 50));
				Text.drawString(g, "SCORE:"+ball.getPoints(), 350, 250, Color.RED, new Font("Lucida Sans Unicode", Font.BOLD, 50));
				Text.drawString(g, "HIGHSCORE:"+getHighScore(), 350, 400, Color.RED, new Font("Lucida Sans Unicode", Font.BOLD, 50));
				Text.drawString(g, "PRESS SPACE TO RESTART", 200, 700, Color.GREEN, new Font("Lucida Sans Unicode", Font.BOLD, 50));
			}
	}
	public int getHighScore()
	{
		if(ball.getPoints()>highscore)
			highscore = ball.getPoints();
		return highscore;
	}
	public void brickSet()
	{
		 boolean power = false;
		 int randSpotx = 0;
		 int randSpoty=0;
		if((int)(Math.random()*2)==1)
			 power = true;
		 if(power)
		 {
			 randSpotx = (int)(Math.random()*6);
			 randSpoty = (int)(Math.random()*7);
		 }
	     for (int i = 0; i < 6; i++) {
	       for (int j = 0; j < 7; j++) {
	    	   if(power && i == randSpotx && j == randSpoty)
	    		   bricks.add(new RandBrick(ball, (double)j * 140 + 10,(double) i * 50 + 95, 130, 50));
	    	   else bricks.add(new Brick(new Color((int)(Math.random()*206)+50, (int)(Math.random()*206)+50, (int)(Math.random()*206)+50),ball,(double)j * 140 + 10,(double) i * 50 + 95, 130, 50));
	        }
	     }
	}
	public void brickClear()
	{
		bricks.clear();
	}
}
