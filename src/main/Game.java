package main;

import java.awt.Color;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;
import model.Body;
import model.Universe;

public class Game {
	private SpaceGUI spaceGUI;
	private Universe universe;
	private Body spaceship;
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
		SolarSystem.populate();
		universe.setBodies(SolarSystem.getBodies());
		return universe;
	}
	
	public Body makeSpaceship(){
			Body spaceship = new Body("Red Dwarf",new BigDecimal("10000000000"),10,10,new Vector(ConstantsUniverse.URANUS_ORBIT,ConstantsUniverse.URANUS_ORBIT), new Vector(new BigDecimal("-360000000"), new BigDecimal("-360000000")),Color.red);
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

        System.out.println((new BigDecimal(ConstantsUniverse.SOL_RADIUS)).toString());
        System.out.println(ConstantsSpaceGame.LANDED.toString());
        System.out.println((new BigDecimal(ConstantsUniverse.SOL_RADIUS).add(ConstantsSpaceGame.LANDED)).toString());

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
			if(distanceToSun.compareTo(ConstantsSpaceGame.MINIMUMDISTANCE.add(new BigDecimal(ConstantsUniverse.SOL_RADIUS)))==-1){
				gameOver= true;
				JOptionPane.showMessageDialog(null, "\tOh no! \nYou just crashed into the sun!");
				System.out.println("The " + spaceship.getName() + " just crashed on the sun!");
			} else if (distanceToSun.compareTo(ConstantsUniverse.PLUTO_ORBIT)==1){
					if(isTooFast(SolarSystem.body[0])) // Too fast for the Sun
						if(isTooFast(SolarSystem.body)){ // Too fast for the system
							JOptionPane.showMessageDialog(null,"The " + spaceship.getName() + " is lost in space!");
							System.out.println("The " + spaceship.getName() + " is lost in space!");
							gameOver= true;
						}
			} else if (movements>year*ConstantsSpaceGame.YEARSSUPPLY) {
				System.out.println("No more food or water available in the " + spaceship.getName() + ". The entire crew just died.");
				gameOver= true;
			} else {
				for(int i = 0; i < nr; i++) {
					Body body = bodies[i];
					if (!(body.equals(spaceship))) {
						BigDecimal distance = spaceship.getDistance(body);
						if(distance.compareTo(ConstantsSpaceGame.LANDED.add(new BigDecimal(body.getRadius())))==-1) {
							System.out.println("The " + spaceship.getName() + " landed on "+ body.getName()+".");
						} else if (((distance.add(distances[i].negate())).abs()).compareTo(ConstantsSpaceGame.LANDED.add(new BigDecimal(body.getRadius())))==-1){
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
	public void accelerateSpaceShip(int direction){
		//spaceship.setLocation(new Vector(new BigDecimal("500"),new BigDecimal("500")));
		//spaceship.move(new Vector(new BigDecimal("100000000"),new BigDecimal("1000000000")));
		//spaceship.setVelocity(new Vector(new BigDecimal("-999999999"),new BigDecimal("-999999999")));
		switch (direction) 
			{
			case 0: //UP
				universe.accelerateShip(new Vector(new BigDecimal("0"),new BigDecimal("100000000")));
				break;
			case 1: //DOWN
				universe.accelerateShip(new Vector(new BigDecimal("0"),new BigDecimal("-100000000")));
				break;
			case 2: //LEFT
				universe.accelerateShip(new Vector(new BigDecimal("-100000000"),new BigDecimal("0")));
				break;
			case 3: //RIGHT
				universe.accelerateShip(new Vector(new BigDecimal("100000000"),new BigDecimal("0")));
				break;
			}
	}

	private boolean isTooFast(Body b){
		return spaceship.getVelocity().getLength().compareTo(Vector.sqrt(bodyActraction(b))) > 0;	
	}

	private boolean isTooFast(Body[] b){
		BigDecimal max = BigDecimal.ZERO;
		for (Body body : b){
			max = max.add(bodyActraction(body));
		}
		return spaceship.getVelocity().getLength().compareTo(Vector.sqrt(max)) > 0;	
	}
	
	private BigDecimal bodyActraction(Body b){
		return (ConstantsUniverse.G).multiply(b.getWeight().divide(spaceship.getDistance(b),ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND)).multiply(new BigDecimal(2));
	}
}
