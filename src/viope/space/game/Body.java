package viope.space.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author      Michael Etzel	<524428@student.inholland.nl>
 * @version     0.1
 * @since       2014-04-03
 * This class should implement methods used by phisical objects
 */

public class Body extends Physics
{
	// Fields section
	
	/**
	 * Describes the Body's mass
	 */
	private double mass;
	
	/**
	 * Describes the position on an X axis of a Body
	 */
	private int x;
	
	/**
	 * Describes the position on an Y axis of a Body
	 */
	private int y;
	
	/**
	 * Describes the velocity on an X axis of a Body
	 */
	private double xVel;
	
	/**
	 * Describes the velocity on an Y axis of a Body
	 */
	private double yVel;
	
	/**
	 * Describes the accelleration on an X axis of a Body
	 */
	private double xAcc;
	
	/**
	 * Describes the accelleration on an Y axis of a Body
	 */
	private double yAcc;
	
	/**
	 * The color owned from a Body object
	 */
	private Color color;

	
	public Body(double mass, int x, int y, Color c)
	{
		this.mass = mass;
		this.x = x;
		this.y = y;
		this.color = c;
		xAcc = 0;
		yAcc = 0;
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
