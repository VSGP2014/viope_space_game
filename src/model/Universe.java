package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;

public class Universe {
	Body[] bodies = new Body[0];
	
	public Universe() {
	}
	
	public Universe(Collection<Body> bodies){
		for(Body body: bodies){
			this.add(body);
		}
	}

	public Body[] getBodies() {
		return bodies;
	}
	
	public void setBodies(Body[] bodies){
		this.bodies = bodies;
	}

	public void add(Body body){
		int bl = bodies.length;
		Body[] nb = new Body[bl + 1];
		for(int i = 0; i < bl; i++) {
			nb[i] = bodies[i];
		}
		nb[bl]=body;
		bodies = nb;
	}
	
	// Formula of Newton: F = G * (m1*m2) / r2
	// Direction from self to other, if time interval bigger, we should rotate by .5 alpha 
	public void move() {
		Vector[] deltaVelocities = new Vector[bodies.length];
		for (int i = 0; i< bodies.length;i++) {
			Body self = bodies[i];
			BigDecimal m1 = self.getWeight();
			Vector netForce = new Vector(BigDecimal.ZERO,BigDecimal.ZERO);
			for (int j = 0; j < bodies.length;j++){
				if(i!=j){
					Body other = bodies[j];
					Vector force = other.getLocation().minus(self.getLocation());
					BigDecimal r = force.getLength();
					if(r.compareTo(ConstantsSpaceGame.MINIMUMDISTANCE)==1) {
						BigDecimal m1m2 = m1.multiply(other.getWeight());
						BigDecimal g = ConstantsUniverse.G;
						BigDecimal r2 = r.multiply(r);
						BigDecimal value =  (g.multiply(m1m2)).divide(r2,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND); 
						force = force.times(value.divide(r,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND));
			/**			BigDecimal rotationAngle = (self.getVelocity().getLength()).divide(r,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND).divide(new BigDecimal("2"),ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND);
						if(rotationAngle.compareTo(new BigDecimal("1"))==1){
							System.out.println("Universe move rotation angle to big: " + rotationAngle);
						}**/
						netForce = netForce.add(force);
					}
				}
			}
			deltaVelocities[i]= netForce.divide(m1);
		}
		for (int i = 0; i< bodies.length;i++) {
			bodies[i].move(deltaVelocities[i]);
		}
	}
	
	public String toString(){
		String s = "";
		int nr = bodies.length;
		for(int i = 0; i < nr; i++){
			s = s + bodies[i].toString() + ", distance to " + bodies[0].getName() + ": " + (bodies[i].getLocation()).getDistance(bodies[0].getLocation()) + "\n";
		}
		return s;
	}
}
