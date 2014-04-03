package viope.space.game;

import java.awt.Color;
import java.awt.Graphics;

public class Body extends Physics
{
	private double mass;
	private int x;
	private int y;
	private double xVel;
	private double yVel;
	private double xAcc;
	private double yAcc;
	private Color color;

	public Body(double mass, int x, int y, Color c)
	{
		this.mass = mass;
		this.x = x;
		this.y = y;
		this.color = c;
	}
	
	public void update()
	{
		this.xAcc = 0;
		this.yAcc = 0;
		this.xVel = 10;
		this.yVel = 15;
		this.x += this.xVel;
		this.y += this.yVel;
	}
	
	public void draw(Graphics g)
	{
		g.setColor(this.color);
		g.fillOval(this.x, this.y, 50, 50);
	}
	
	public double getMass()
	{
		return this.mass;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
}
