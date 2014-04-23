package viope.space.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author      Michael Etzel	<524428@student.inholland.nl>
 * @version     0.2
 * @since       2014-04-03
 * This class should implement methods used by phisical objects
 */

public class Body
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
		this.setX(this.getX() + (int)this.getXVel());
		
		this.setYAcc(yf / this.mass);
		this.setYVel(this.getYVel() + this.getYAcc());
		this.setY(this.getY() + (int)this.getYVel());
		
		Physics.clearForces();
	}
	
	/**
	 * The method used to draw the Body.
	 * @param g	The graphical place-holder of the body
	 */
	public void draw(Graphics g)
	{
		g.setColor(this.color);
		g.fillOval(this.x - 15, this.y - 15, 30, 30);
	}
	
	/**
	 * Returns the distance of the actual Body from a target Body.
	 * @param target The Body of which I want to know the distance.
	 * @return A double that is the distance from the target Body.
	 */
	public double getTargetDistance(Body target) {
		double x = Math.abs(this.getX() - target.getX());
		double y = Math.abs(this.getY() - target.getY());
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		
		return distance * scale;
	}
	
	/**
	 * Return the name of the Body.
	 * @return A string containing the Body's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the Body mass.
	 * @return A double containing the Body's mass.
	 */
	public double getMass()
	{
		return this.mass;
	}
	
	/**
	 * Return the Body position on the X axis.
	 * @return An integer containing the Body's position on the X axis.
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Return the Body position on the Y axis.	
	 * @return An integer containing the Body's position on the Y axis.
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Set the Body's current X position.
	 * @param num The new Body's X position.
	 */
	public void setX(int num) {
		this.x = num;
	}
	
	/**
	 * Set the Body's current Y position.
	 * @param num The new Body's Y position.
	 */
	public void setY(int num) {
		this.y = num;
	}
	
	/**
	 * Return the X axis Body's velocity.
	 * @return A double containing the X axis Body's velocity.
	 */
	public double getXVel()
	{
		return this.xVel;
	}
	
	/**
	 * Set the Body's velocity on the X axis.
	 * @param num The new Body's X axis velocity.
	 */
	public void setXVel(double num)
	{
		this.xVel = num;
	}
	
	/**
	 * Return the Y axis Body's velocity.
	 * @return A double containing the Y axis Body's velocity.
	 */
	public double getYVel()
	{
		return this.yVel;
	}
	
	/**
	 * Set the Body's velocity on the Y axis.
	 * @param num The new Body's Y axis velocity.
	 */
	public void setYVel(double num)
	{
		this.yVel = num;
	}
	
	/**
	 * Return the X axis Body's accelleration.
	 * @return A double containing the X axis Body's accelleration.
	 */
	public double getXAcc()
	{
		return this.xAcc;
	}
	
	/**
	 * Set the Body's accelleration on the X axis.
	 * @param num The new Body's X axis accelleration.
	 */
	public void setXAcc(double num)
	{
		this.xAcc = num;
	}
	
	/**
	 * Return the Y axis Body's accelleration.
	 * @return A double containing the Y axis Body's accelleration.
	 */
	public double getYAcc()
	{
		return this.yAcc;
	}
	
	/**
	 * Set the Body's accelleration on the Y axis.
	 * @param num The new Body's Y axis accelleration.
	 */
	public void setYAcc(double num)
	{
		this.yAcc = num;
	}
	
	/**
	 * Return a string with informations related to the Body.
	 * @return A string with the Body's name and coordinates.
	 */
	public String toString() {
		return this.getName()+" ("+this.getX()+","+this.getY()+")";
	}
	
	/**
	 * Return full informations about the Body.
	 */
	public String fullString() {
		return this.toString()+" xVel:"+this.getXVel()+" yVel:"+this.getYVel()+" xAcc:"+this.getXAcc()+" yAcc:"+this.getYAcc()+" Mass:"+this.getMass();  
	}
}
