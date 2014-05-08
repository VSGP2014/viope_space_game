package main;

import java.awt.Color;
import java.math.BigDecimal;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;
import model.Body;
import model.Universe;

public class Game {
	private SpaceGUI spaceGUI;
	private Universe universe;
	private Body spaceship, sun;
	private int movements = 0;
	private int weeks = 0;
	boolean gameOver = false;
	
	public Game(){
		universe = buildUniverse();
		spaceship = makeSpaceship();
		universe.add(spaceship);
	}
	
	public Universe buildUniverse(){
		Universe universe = new Universe();
		//Building the universe
		//sun at the centre
		BigDecimal iv = new BigDecimal(ConstantsSpaceGame.INTERVAL);
		sun = new Body("Sun",ConstantsUniverse.SOL_MASS,new Vector(BigDecimal.ZERO,BigDecimal.ZERO),new Vector(BigDecimal.ZERO,BigDecimal.ZERO),Color.yellow);
		
		//- Planets
		//mercury 90 degrees
		Body mercury = new Body("Mercury",ConstantsUniverse.MERCURY_MASS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray);
		//venus 180 degrees
		Body venus = new Body("Venus",ConstantsUniverse.VENUS_MASS,new Vector(new BigDecimal("99354743695"),new BigDecimal("41216438530")),new Vector((new BigDecimal("-13410.1941666667")).multiply(iv),(new BigDecimal("32504.2688888889")).multiply(iv)), Color.yellow);
		//earth -90 degrees
		Body earth = new Body("Earth",ConstantsUniverse.EARTH_MASS,new Vector(new BigDecimal("-150642797838"),new BigDecimal("1923202429")),new Vector((new BigDecimal("-276.230277777778")).multiply(iv),(new BigDecimal("-29675.1219444444")).multiply(iv)), Color.cyan);
		//mars 0 degrees
		Body mars = new Body("Mars",ConstantsUniverse.MARS_MASS,new Vector(new BigDecimal("153664144694"),new BigDecimal("167967118516")),new Vector((new BigDecimal("-17838.9758333333")).multiply(iv),(new BigDecimal("16225.2333333333")).multiply(iv)), Color.magenta);
		//jupiter 90 degrees
		Body jupiter = new Body("Jupiter",ConstantsUniverse.JUPITER_MASS,new Vector(new BigDecimal("-694716630665"),new BigDecimal("375901422954")),new Vector((new BigDecimal("-6308.06138888889")).multiply(iv),(new BigDecimal("-11374.4652777778")).multiply(iv)), Color.orange);
		//saturn 180 degrees
		Body saturn= new Body("Saturn",ConstantsUniverse.SATURN_MASS,new Vector(new BigDecimal("-448174651642"),new BigDecimal("1376849128150")),new Vector((new BigDecimal("-9093.19138888889")).multiply(iv),(new BigDecimal("-3087.7525")).multiply(iv)), Color.yellow);
		//uranus -90 degrees
		Body uranus = new Body("Uranus",ConstantsUniverse.URANUS_MASS,new Vector(new BigDecimal("-2391759765802"),new BigDecimal("1426163340668")),new Vector((new BigDecimal("-3613.13555555556")).multiply(iv),(new BigDecimal("-5925.83194444444")).multiply(iv)), Color.blue);
		//neptune 0 degrees
		Body neptune = new Body("Neptune",ConstantsUniverse.NEPTUNE_MASS,new Vector(new BigDecimal("1246757671891"),new BigDecimal("-4311648093455")),new Vector((new BigDecimal("5225.02638888889")).multiply(iv),(new BigDecimal("1494.01972222222")).multiply(iv)), Color.lightGray);
		//pluto 90 degrees
		Body pluto = new Body("Pluto",ConstantsUniverse.PLUTO_MASS,new Vector(new BigDecimal("-5367382317922"),new BigDecimal("2643960334520")),new Vector((new BigDecimal("-2057.39972222222")).multiply(iv),(new BigDecimal("-4243.28388888889")).multiply(iv)), Color.white);
		
		//- Moons 
		// got from (https://solarsystem.nasa.gov/planets/index.cfm) <- took ages to find it...
		// used also for ConstantsUniverse
		//Earth
		Body moon = new Body("Moon",ConstantsUniverse.MOON_MASS,new Vector(new BigDecimal("-150643182238"),new BigDecimal("1923202429")),new Vector((new BigDecimal("0")).multiply(iv),(new BigDecimal("1030")).multiply(iv)), Color.gray);
		//Jupiter
		Body io = new Body("Io",ConstantsUniverse.IO_MASS,new Vector(new BigDecimal("-694294830665"),new BigDecimal("375901422954")),new Vector((new BigDecimal("0")).multiply(iv),(new BigDecimal("17334")).multiply(iv)), Color.green);
		Body europa = new Body("Europa",ConstantsUniverse.EUROPA_MASS,new Vector(new BigDecimal("-694716630665"),new BigDecimal("376572522954")),new Vector((new BigDecimal("-13740")).multiply(iv),(new BigDecimal("0")).multiply(iv)), Color.gray);
		Body ganymede = new Body("Ganymede",ConstantsUniverse.GANYMEDE_MASS,new Vector(new BigDecimal("-695787030665"),new BigDecimal("375901422954")),new Vector((new BigDecimal("0")).multiply(iv),(new BigDecimal("-10880")).multiply(iv)), Color.gray);
		Body callisto = new Body("Callisto",ConstantsUniverse.CALLISTO_MASS,new Vector(new BigDecimal("-694716630665"),new BigDecimal("374018722954")),new Vector((new BigDecimal("8204")).multiply(iv),(new BigDecimal("0")).multiply(iv)), Color.gray);
		//Saturn - commented one has uncorrect datas for position and speed
		//Body mimas = new Body("Mimas",ConstantsUniverse.MIMAS_MASS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray);
		//Body iapetus = new Body("Iapetus",ConstantsUniverse.IAPETUS_MASS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray);
		//Body tethys = new Body("Tethys",ConstantsUniverse.TETHYS_MASS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray);
		Body dione = new Body("Dione",ConstantsUniverse.DIONE_MASS,new Vector(new BigDecimal("-448552066642"),new BigDecimal("1376849128150")),new Vector((new BigDecimal("0")).multiply(iv),(new BigDecimal("10030")).multiply(iv)), Color.gray);
		//Body rhea = new Body("Rhea",ConstantsUniverse.RHEA_MASS,new Vector(new BigDecimal("-42471132551"),new BigDecimal("-39584006147")),new Vector((new BigDecimal("32486.6269444444")).multiply(iv),(new BigDecimal("-35094.635")).multiply(iv)), Color.gray);
		Body titan = new Body("Titan",ConstantsUniverse.TITAN_MASS,new Vector(new BigDecimal("-448174651642"),new BigDecimal("1378070993150")),new Vector((new BigDecimal("-5570")).multiply(iv),(new BigDecimal("0")).multiply(iv)), Color.orange);
		//Uranus
		Body titania = new Body("Titania",ConstantsUniverse.TITANIA_MASS,new Vector(new BigDecimal("-2391759765802"),new BigDecimal("1425727040668")),new Vector((new BigDecimal("36500")).multiply(iv),(new BigDecimal("-0")).multiply(iv)), Color.gray);
		//Neptune
		Body triton = new Body("Triton",ConstantsUniverse.TRITON_MASS,new Vector(new BigDecimal("1247112430891"),new BigDecimal("-4311648093455")),new Vector((new BigDecimal("0")).multiply(iv),(new BigDecimal("4389")).multiply(iv)), Color.white);

		// Do it!
		universe.add(sun);
		// Planets
		universe.add(mercury);
		universe.add(venus);
		universe.add(earth);
		universe.add(mars);
		universe.add(jupiter);
		universe.add(saturn);
		universe.add(uranus);
		universe.add(neptune);
		universe.add(pluto);
		// Moons
		universe.add(moon);
		universe.add(io);
		universe.add(europa);
		universe.add(ganymede);
		universe.add(callisto);
		universe.add(dione);
		universe.add(titan);
		universe.add(titania);
		universe.add(triton);

		return universe;
	}
	
	public Body makeSpaceship(){
			Body spaceship = new Body("Red Dwarf",new BigDecimal("10000000000"),new Vector(ConstantsUniverse.URANUS_ORBIT,ConstantsUniverse.URANUS_ORBIT), new Vector(new BigDecimal("-360000000"), new BigDecimal("-360000000")),Color.red);
		return spaceship;
	}
	
	public void setInitialVelocity(BigDecimal xVel, BigDecimal yVel){
		spaceship.setVelocity(new Vector(xVel,yVel));
	}
	
	public void runGame(){
		//Let it run with the universe and check where it is
		Body[] bodies = universe.getBodies();
		Body sun = bodies[0];
		int nr = bodies.length;
		BigDecimal[] distances = new BigDecimal[nr];
		for (int i = 0; i < nr;i++) {
			distances[i] = new BigDecimal("0");
		}
		
		int day = 60*60*24/ConstantsSpaceGame.INTERVAL;
		int week = day * 7;
		int month = day*30;
		int year = month*12;

		for (int i = 0; i < 2*week;i++){
			universe.move();
		}
		while (!(gameOver)) {
			if(movements%(week)==0){
				weeks = weeks + 1;
				System.out.println("Week number " + weeks);
				System.out.println(universe.toString());
			} 
			movements = movements + 1; 
			universe.move();
			spaceGUI.repaint();
			BigDecimal distanceToSun = spaceship.getDistance(sun);
			if(distanceToSun.compareTo(ConstantsSpaceGame.MINIMUMDISTANCE)==-1){
				gameOver= true;
				System.out.println("The " + spaceship.getName() + " just crashed on the sun!");
			} else if (distanceToSun.compareTo(ConstantsSpaceGame.LOST)==1){
				System.out.println("The" + spaceship.getName() + " is lost in space!");
				gameOver= true;
			} else if (movements>year*ConstantsSpaceGame.YEARSSUPPLY) {
				System.out.println("No more food or water available in the " + spaceship.getName() + ". The entire crew just died.");
				gameOver= true;
			} else {
				for(int i = 0; i < nr; i++) {
					Body body = bodies[i];
					if (!(body.equals(spaceship))) {
						BigDecimal distance = spaceship.getDistance(body);
						if(distance.compareTo(ConstantsSpaceGame.MINIMUMDISTANCE)==-1) {
							System.out.println("The " + spaceship.getName() + " landed on "+ body.getName()+".");
						} else if (((distance.add(distances[i].negate())).abs()).compareTo(ConstantsSpaceGame.MINIMUMDISTANCE)==-1){
							System.out.println("The " + spaceship.getName() + " is in a stationary orbit around" + body.getName()+".");
						}
					}
				}
			}
		}
		System.out.println(universe.toString());
	}

	public Universe getUniverse() {
		return universe;
	}

	public void setSpaceGUI(SpaceGUI spaceGUI) {
		this.spaceGUI = spaceGUI;
	}
	

}
