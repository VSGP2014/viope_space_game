package model;
import java.awt.Color;
import java.math.BigDecimal;

import utils.Vector;

/**
 * The physical rappresentation of a body with mass and speed.
 */
public class Body {
	private String name;
	private BigDecimal weight; // Weight in kg
	private int size;
	private Vector location; // in m, m, m
	private Vector velocity; //in m, m, m
	private Color color;
	
	/**
	 * Creates a new Body with the values used.
	 * @param name The Body's name (as the name of a planet...!).
	 * @param weight The Body's weight.
	 * @param size The Body's radius (just for circular bodies)
	 * @param location The vector containing the position in a 2D space of the Body.
	 * @param velocity The vector containing the velocity in a 2D space of the Body.
	 * @param color The Body's color.
	 */
	public Body(String name, BigDecimal weight, int size, Vector location,  Vector velocity, Color color) {
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.location = location;
		this.velocity = velocity;
		this.color = color;
	}

	/**
	 * Used for getting the Body's name.
	 * @return A String with the Body's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Used for setting the Body's name.
	 * @param name The new Body's name.
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Used for getting the Body's weight.
	 * @return A BigDecimal of the Body's weight.
	 */
	public BigDecimal getWeight() {
		return weight;
	}

	/**
	 * Used for setting the Body's weight.
	 * @param weight A BigDecimal with the new Body's weight.
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	/**
	 * Used for getting the Body's size.
	 * @return An integer with the Body's radius.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Used for setting the Body's radius.
	 * @param size An integer with the new Body's radius.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Used for getting the Body's position.
	 * @return A Vector containing the Body's position.
	 */
	public Vector getLocation(){
		return location;
	}
	
	/**
	 * Used for setting the Body's name.
	 * @param location A Vector with the new Body's location.
	 */
	public void setLocation(Vector location){
		this.location = location;
	}
	
	/**
	 * Used for getting the Body's velocity.
	 * @return A Vector containing the Body's velocity.
	 */
	public Vector getVelocity() {
		return velocity;
	}

	/**
	 * Used for setting the Body's name.
	 * @param velocity A Vector with the new Body's velocity.
	 */
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	/**
	 * Used for getting the Body's color.
	 * @return The Body's Color.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Used for getting the Body's color.
	 * @param color The Body's new Color.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * Used to add weight to a Body.
	 * @param weight The weight to add.
	 */
	public void addWeight(BigDecimal weight) {
		this.weight = this.weight.add(weight);
	}
	
	/**
	 * Used to calculate the distance between two Body.
	 * @param other The Body from which I need the distance.
	 * @return A BigDecimal containing the distance between the Body.
	 */
	public BigDecimal getDistance(Body other) {
		return location.getDistance(other.location);
	}
	
	/**
	 * Used for moving a Body and update its position, given its actual velocity.
	 * @param deltaVelocity The differences of velocities in a Vector.
	 */
	public void move(Vector deltaVelocity){
		velocity = velocity.add(deltaVelocity);
		location = location.add(velocity);
	}
	
	/**
	 * Return a string with some informations about the Body.
	 */
	public String toString(){
		return ""+ name +", location: "+ location.toString()+", speed: "+ velocity.toString();
	}
}
