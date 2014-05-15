package main;
import model.Body;

import java.math.BigDecimal;
import java.awt.Color;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;


public class SolarSystem {
	
	public static Body[] body = new Body[19];
	public static Body temp;
	
	public static void populate(){
	BigDecimal iv = new BigDecimal(ConstantsSpaceGame.INTERVAL);	
	temp = new Body("Sun",ConstantsUniverse.SOL_MASS,ConstantsUniverse.SOL_SIZE,new Vector(BigDecimal.ZERO,BigDecimal.ZERO),new Vector(BigDecimal.ZERO,BigDecimal.ZERO),Color.yellow);
	body[0] = temp;
	body[1] = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,ConstantsUniverse.MERCURY_SIZE,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray); 
	body[2] = new Body("Venus",ConstantsUniverse.VENUS_MASS,ConstantsUniverse.VENUS_SIZE,new Vector(new BigDecimal("99354743695"),new BigDecimal("41216438530")),new Vector((new BigDecimal("-13410.1941666667")).multiply(iv),(new BigDecimal("32504.2688888889")).multiply(iv)), Color.yellow);
	body[3] = new Body("Earth",ConstantsUniverse.EARTH_MASS,ConstantsUniverse.EARTH_SIZE,new Vector(new BigDecimal("-150642797838"),new BigDecimal("1923202429")),new Vector((new BigDecimal("-276.230277777778")).multiply(iv),(new BigDecimal("-29675.1219444444")).multiply(iv)), Color.cyan);
	//mars 0 degrees
	body[4] = new Body("Mars",ConstantsUniverse.MARS_MASS,ConstantsUniverse.MARS_SIZE,new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516")),new Vector((new BigDecimal("-17838.9758333333")).multiply(iv),(new BigDecimal("16225.2333333333")).multiply(iv)), Color.magenta);
	//jupiter 90 degrees
	body[5] = new Body("Jupiter",ConstantsUniverse.JUPITER_MASS,ConstantsUniverse.JUPITER_SIZE,new Vector(new BigDecimal("-694716630665"),new BigDecimal("375901422954")),new Vector((new BigDecimal("-6308.06138888889")).multiply(iv),(new BigDecimal("-11374.4652777778")).multiply(iv)), Color.orange);
	//saturn 180 degrees
	body[6]= new Body("Saturn",ConstantsUniverse.SATURN_MASS,ConstantsUniverse.SATURN_SIZE,new Vector(new BigDecimal("-448174651642"),new BigDecimal("1376849128150")),new Vector((new BigDecimal("-9093.19138888889")).multiply(iv),(new BigDecimal("-3087.7525")).multiply(iv)), Color.yellow);
	//uranus -90 degrees
	body[7] = new Body("Uranus",ConstantsUniverse.URANUS_MASS,ConstantsUniverse.URANUS_SIZE,new Vector(new BigDecimal("-2391759765802"),new BigDecimal("1426163340668")),new Vector((new BigDecimal("-3613.13555555556")).multiply(iv),(new BigDecimal("-5925.83194444444")).multiply(iv)), Color.blue);
	//neptune 0 degrees
	body[8] = new Body("Neptune",ConstantsUniverse.NEPTUNE_MASS,ConstantsUniverse.NEPTUNE_SIZE,new Vector(new BigDecimal("1246757671891"),new BigDecimal("-4311648093455")),new Vector((new BigDecimal("5225.02638888889")).multiply(iv),(new BigDecimal("1494.01972222222")).multiply(iv)), Color.lightGray);
	//pluto 90 degrees
	body[9] = new Body("Pluto",ConstantsUniverse.PLUTO_MASS,ConstantsUniverse.PLUTO_SIZE,new Vector(new BigDecimal("-5367382317922"),new BigDecimal("2643960334520")),new Vector((new BigDecimal("-2057.39972222222")).multiply(iv),(new BigDecimal("-4243.28388888889")).multiply(iv)), Color.white);
	
	// variables for easier stuff
	Body earth = body[3];
	Body jupiter = body[5];
	Body saturn = body[6];
	Body uranus = body[7];
	Body neptune = body[8];
	
	//- Moons 
	body[10] = new Body("Moon",ConstantsUniverse.MOON_MASS,ConstantsUniverse.MOON_SIZE,earth.getLocation().add(new Vector(ConstantsUniverse.MOON_ORBIT, BigDecimal.ZERO)),earth.getVelocity().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.MOON_SPEED)), Color.gray);
	//Jupiter
	body[11] = new Body("Io",ConstantsUniverse.IO_MASS,ConstantsUniverse.IO_SIZE,jupiter.getLocation().add(new Vector(ConstantsUniverse.IO_ORBIT,BigDecimal.ZERO)),jupiter.getVelocity().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.IO_SPEED)), Color.gray);
	body[12] = new Body("Europa",ConstantsUniverse.EUROPA_MASS,ConstantsUniverse.EUROPA_SIZE,jupiter.getLocation().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.EUROPA_ORBIT)),jupiter.getVelocity().add(new Vector(ConstantsUniverse.EUROPA_SPEED.negate(),BigDecimal.ZERO)), Color.gray);
	body[13] = new Body("Ganymede",ConstantsUniverse.GANYMEDE_MASS,ConstantsUniverse.GANYMEDE_SIZE,jupiter.getLocation().add(new Vector(ConstantsUniverse.GANYMEDE_ORBIT.negate(),BigDecimal.ZERO)),jupiter.getVelocity().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.GANYMEDE_SPEED.negate())), Color.gray);
	body[14] = new Body("Callisto",ConstantsUniverse.CALLISTO_MASS,ConstantsUniverse.CALLISTO_SIZE,jupiter.getLocation().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.CALLISTO_ORBIT.negate())),jupiter.getVelocity().add(new Vector(ConstantsUniverse.CALLISTO_SPEED,BigDecimal.ZERO)), Color.gray);
	//Saturn
	body[15] = new Body("Dione",ConstantsUniverse.DIONE_MASS,ConstantsUniverse.DIONE_SIZE,saturn.getLocation().add(new Vector(ConstantsUniverse.DIONE_ORBIT.negate(),BigDecimal.ZERO)),saturn.getVelocity().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.DIONE_SPEED.negate())), Color.gray);
	body[16] = new Body("Titan",ConstantsUniverse.TITAN_MASS,ConstantsUniverse.TITAN_SIZE,saturn.getLocation().add(new Vector(ConstantsUniverse.TITAN_ORBIT,BigDecimal.ZERO)),saturn.getVelocity().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.TITAN_SPEED)), Color.orange);
	//Uranus
	body[17] = new Body("Titania",ConstantsUniverse.TITANIA_MASS,ConstantsUniverse.TITANIA_SIZE,uranus.getLocation().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.TITANIA_ORBIT)),uranus.getVelocity().add(new Vector(ConstantsUniverse.TITAN_SPEED.negate(),BigDecimal.ZERO)), Color.gray);
	//Neptune
	body[18] = new Body("Triton",ConstantsUniverse.TRITON_MASS,ConstantsUniverse.TRITON_SIZE,neptune.getLocation().add(new Vector(BigDecimal.ZERO,ConstantsUniverse.TRITON_ORBIT.negate())),neptune.getVelocity().add(new Vector(ConstantsUniverse.TRITON_SPEED,BigDecimal.ZERO)), Color.white);
	}
	
	public static Body[] getBodies() {
		return body;
	}
}
