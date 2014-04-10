package viope.space.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author      Michael Etzel	<524428@student.inholland.nl>
 * @version     0.2
 * @since       2014-04-03
 * This class should implement methods used by phisical objects
 */

public class Body extends Physics
{
	/**
	 * Meters per pixel ratio
	 */
	static public double scale = 737500000;
	
	/**
	 * The Body's name
	 */
	private String name;
	
	/**
	 * The Body's mass
	 */
	private double mass;
	
	/**
	 * The position on an X axis of a Body
	 */
	private int x;
	
	/**
	 * The position on an Y axis of a Body
	 */
	private int y;
	
	/**
	 * The velocity on an X axis of a Body
	 */
	protected double xVel;
	
	/**
	 * The velocity on an Y axis of a Body
	 */
	protected double yVel;
	
	/**
	 * The accelleration on an X axis of a Body
	 */
	private double xAcc;
	
	/**
	 * The accelleration on an Y axis of a Body
	 */
	private double yAcc;
	
	/**
	 * The color owned from a Body object
	 */
	private Color color;

	/**
	 * Creates a physical object (like a planet or a spaceship) that
	 * obeys to physics law.
	 * 
	 * @param mass 	The mass of the Body
	 * @param x    	The X initial position of the Body
	 * @param y		The Y initial position of the Body
	 * @param c		The color of the Body
	 */
	public Body(String name, double mass, int x, int y, Color c) {
		this.name = name;
		this.mass = mass;
		this.x = x;
		this.y = y;
		this.color = c;
	}
	
	/**
	 * Using Physics class, updates the actual Body position.
	 */
	public void update() {
		double xf = Physics.sumForce(Physics.getNetXForce(this));
		double yf = Physics.sumForce(Physics.getNetYForce(this));
		this.setXAcc(xf / this.mass);
		this.setXVel(this.getXVel() + this.getXAcc());
		this.setX(this.getX() + this.getXVel());
		
		this.setYAcc(yf / this.mass);
		this.setYVel(this.getYVel() + this.getYAcc());
		this.setY(this.getY() + this.getYVel());
		
		Physics.clearForces();
	}
	
	/**
	 * The method used to draw the Body.
	 * @param g
	 */
	public void draw(Graphics g)
	{
		g.setColor(this.color);
		g.fillOval(this.x - 15, this.y - 15, 30, 30);
	}
	
	/**
	 * To write
	 * @param target
	 * @return
	 */
	public double getTargetDistance(Body target) {
		double x = Math.abs(this.getX() - target.getX());
		double y = Math.abs(this.getY() - target.getY());
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		
		return distance * scale;
	}
	
	/**
	 * To write
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the Body mass.
	 * @return
	 */
	public double getMass()
	{
		return this.mass;
	}
	
	/**
	 * Return the Body position on the X axis.
	 * @return
	 */
	public double getX()
	{
		return this.x;
	}
	
	/**
	 * Return the Body position on the X axis.	
	 * @return
	 */
	public double getY()
	{
		return this.y;
	}
	
	public void setX(double num)
	{
		this.x = (int) num;
	}
	
	public void setY(double num)
	{
		this.y = (int) num;
	}
	
	public double getXVel()
	{
		return this.xVel;
	}
	
	public void setXVel(double num)
	{
		this.xVel = num;
	}
	
	public double getYVel()
	{
		return this.yVel;
	}
	
	public void setYVel(double num)
	{
		this.yVel = num;
	}
	
	public double getXAcc()
	{
		return this.xAcc;
	}
	
	public void setXAcc(double num)
	{
		this.xAcc = num;
	}
	
	public double getYAcc()
	{
		return this.yAcc;
	}
	
	public void setYAcc(double num)
	{
		this.yAcc = num;
	}
}
