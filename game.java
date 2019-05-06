package dev.adiswami.finalproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import dev.adiswami.finalproject.display.Display;
import dev.adiswami.finalproject.entities.Ball;
import dev.adiswami.finalproject.gfx.Assets;
import dev.adiswami.finalproject.gfx.ImageLoader;
import dev.adiswami.finalproject.gfx.SpriteSheet;
import dev.adiswami.finalproject.input.KeyManager;
import dev.adiswami.finalproject.input.Mouser;
import dev.adiswami.finalproject.states.GameState;
import dev.adiswami.finalproject.states.MenuState;
import dev.adiswami.finalproject.states.State;

public class Game implements Runnable{
	private Display display;
	String title;
	int width, height;
	private Thread thread;
	private BufferStrategy buffstrat;
	private Graphics g;
	int x=450;
	boolean r = false; //checks if game is running
	//States
	public State gameState;
	public State menuState;
	private BufferedImage beach;
	private KeyManager keyer;
	private Mouser mouse;
	public Game(String title, int width, int height)
	{
		this.title= title;
		this.width = width;
		this.height = height;
	}
	private void init()
	{
		display = new Display(title, width, height);
		beach = ImageLoader.loadImage("/images/beach.png");
		keyer = new KeyManager();
		mouse = new Mouser();
		display.getFrame().addKeyListener(keyer);
		display.getFrame().addMouseListener(mouse);
		display.getFrame().addMouseListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		display.getCanvas().addMouseListener(mouse);
		Assets.init();
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(menuState);
		//State.setState(gameState);
	}
	public void update()
	{
		keyer.tick();
		if(State.getState()!=null)
			State.getState().tick();
	}
	public void render()
	{
		buffstrat = display.getCanvas().getBufferStrategy(); //helps draw --> Buffer is a hiddens screen
		if(buffstrat ==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = buffstrat.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//Draw
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0, width, height);
		
		/*g.drawImage(beach, 495, 685, null);
		g.drawImage(Assets.player,x, 710, null);*/
		if(State.getState()!=null)
			State.getState().render(g);
		//End the drawing
		buffstrat.show();
		g.dispose();
	}
	public void run()
	{
		init();
		int fps =60;
		double timePerTick = 1000000000/fps;
		double delta =0;
		long now;
		long lastTime = System.nanoTime();
		while(r)
		{
			now = System.nanoTime();
			delta+=((now-lastTime)/timePerTick);
			lastTime = now;
			if(delta>=1)
			{
				update();
				render();
				delta--;
			}
		}
		stop();
	}
	public KeyManager getKeyer(){return keyer;}
	public Mouser getMouse(){return mouse;}
	public synchronized void start()
	{
		if(r)
			return;
		r = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if(!r)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
