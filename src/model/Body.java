package model;
import java.awt.Color;
import java.math.BigDecimal;

import utils.Vector;


public class Body {
	private String name;
	private BigDecimal weight; // Weight in kg
	private Vector location; // in m, m, m
	private Vector velocity; //in m, m, m
	private Color color;
	
	public Body(String name, BigDecimal weight, Vector location,  Vector velocity, Color color) {
		this.name = name;
		this.weight = weight;
		this.location = location;
		this.velocity = velocity;
		this.color = color;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Vector getLocation(){
		return location;
	}
	
	public void setLocation(Vector location){
		this.location = location;
	}
	
	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void addWeight(BigDecimal weight) {
		this.weight = this.weight.add(weight);
	}
	
	public BigDecimal getDistance(Body other) {
		return location.getDistance(other.location);
	}
	
	public void move(Vector deltaVelocity){
		velocity = velocity.add(deltaVelocity);
		location = location.add(velocity);
	}
	
	public String toString(){
		return ""+ name +", location: "+ location.toString()+", speed: "+ velocity.toString();
	}
}
