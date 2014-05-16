package model;

import java.math.BigDecimal;
import java.util.Collection;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;

/**
 * A class that rappresents a Universe as a container of Body.
 */
public class Universe {
	/**
	 * The placeholder for the Body.
	 */
	Body[] bodies = new Body[0];
	
	/**
	 * Creates a universe.
	 */
	public Universe() {
	}
	
	/**
	 * Creates a Universe with the given Body Collection.
	 * @param bodies A Collection of Body that we want in the universe.
	 */
	public Universe(Collection<Body> bodies){
		for(Body body: bodies){
			this.add(body);
		}
	}

	/**
	 * Used to get the Body array contained in a Universe.
	 * @return The reference to the Universe Body array.
	 */
	public Body[] getBodies() {
		return bodies;
	}
	
	/**
	 * Used to set the Body array of a Universe.
	 * @param bodies The reference to the new Universe Body array.
	 */
	public void setBodies(Body[] bodies){
		this.bodies = bodies;
	}
	
	/**
	 * Used to add a Body to a Universe.
	 * @param body The Body to add to the Universe.
	 */
	public void add(Body body){
		int bl = bodies.length;
		Body[] nb = new Body[bl + 1];
		for(int i = 0; i < bl; i++) {
			nb[i] = bodies[i];
		}
		nb[bl]=body;
		bodies = nb;
	}
	
	/**
	 * Used for accellerate the SpaceShip.
	 * @param vector The speed to add to the SpaceShip.
	 */
	public void accelerateShip(Vector vector){
		for(int i=0;i<bodies.length;i++){
			//bodies[i].setVelocity(new Vector(new BigDecimal("999999999"),new BigDecimal("999999999")));
			if(bodies[i].getName().equals("Red Dwarf")){
				vector=vector.add(bodies[i].getVelocity());
				bodies[i].setVelocity(vector);
				break;
			}
		}
	}
	// Formula of Newton: F = G * (m1*m2) / r2
	// Direction from self to other, if time interval bigger, we should rotate by .5 alpha 
	/**
	 * The MAIN method! Moves ALL THE THINGS!
	 */
	public void move() {
		Vector[] deltaVelocities = new Vector[bodies.length];
		Vector[][] symForce = new Vector[bodies.length][bodies.length];// Will use for symmetry purposes.
		for (int i = 0; i < bodies.length; i++) {
			Body self = bodies[i];
			BigDecimal m1 = self.getWeight();
			Vector netForce = new Vector(BigDecimal.ZERO,BigDecimal.ZERO);
			for (int j = i+1; j < bodies.length; j++){
					Body other = bodies[j];
					Vector force = other.getLocation().minus(self.getLocation());
					BigDecimal r = force.getLength();
					if(r.compareTo(ConstantsSpaceGame.MINIMUMDISTANCE)==1) {
						BigDecimal m1m2 = m1.multiply(other.getWeight());
						BigDecimal g = ConstantsUniverse.G;
						BigDecimal r2 = r.multiply(r);
						BigDecimal value =  (g.multiply(m1m2)).divide(r2,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND); 
						force = force.times(value.divide(r,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND));
						/**			
						BigDecimal rotationAngle = (self.getVelocity().getLength()).divide(r,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND).divide(new BigDecimal("2"),ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND);
						if(rotationAngle.compareTo(new BigDecimal("1"))==1){
							System.out.println("Universe move rotation angle to big: " + rotationAngle);
						}**/
						symForce[i][j] = force;
						netForce = netForce.add(force);
						} else {
							symForce[i][j] = new Vector(new BigDecimal("0"),new BigDecimal("0"));
						}
			}
			
			 for (int j=0; j < i; j++) {
			 	netForce=netForce.minus(symForce[j][i]);
			 }
						
			deltaVelocities[i]= netForce.divide(m1);	
		}
		for (int i = 0; i< bodies.length;i++) {
			bodies[i].move(deltaVelocities[i]);
		}
	}
	
	/**
	 * Used to print informations of the Body inside the Universe.
	 */
	public String toString(){
		String s = "";
		int nr = bodies.length;
		for(int i = 0; i < nr; i++){
			s = s + bodies[i].toString() + ", distance to " + bodies[0].getName() + ": " + (bodies[i].getLocation()).getDistance(bodies[0].getLocation()) + "\n";
		}
		return s;
	}
}



