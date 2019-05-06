package dev.adiswami.finalproject.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
	private double x, y;
	private int width;
	private int height;
	private Graphics g = null;
	public Entity(double x, double y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Rectangle getRect(int x, int y, int width, int height) {
        return new Rectangle(x, y, width, height);
    }
	public double getX(){return x;}
	public double getY(){return y;}
	public void setY(double k){y=k;}
	public void setX(double k){x=k;}
	public abstract void tick();
	public abstract void render(Graphics g);
}
