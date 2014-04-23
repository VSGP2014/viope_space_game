package viope.space.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Margarida & Monica
 * This class should contain all the stuff needed for creating a virtual copy of our solar system.
 */
public class SolarSystem 
{
	final static int NUM_PLANETS=7, NUM_MAX_STARS=10000;
	static ArrayList<Body> universe = new ArrayList<Body>();
	static Body sun = new Body("Sun", 1.99 * Math.pow(10, 30), 400, 400, Color.yellow);
	static Planet planets[] = new Planet[NUM_PLANETS];
	static Star stars[] = new Star[NUM_MAX_STARS];
	
	public SolarSystem()
	{
		createPlanets(planets);
		createStars(stars);
		
		universe.add(sun);
		
		for (int i = 0; i < planets.length; i++) {
			universe.add(planets[i]);
		}
		
		for (int i = 0; i < stars.length; i++) {
			universe.add(stars[i]);
		}
		
	}
	public Planet[] getPlanets()
	{
		return planets;
	}
	public void createPlanets(Planet planets[])
	{
		Planet mercury = null;
		planets[0] = mercury;
		Planet venus = null;
		planets[1] = venus;
		Planet earth = new Planet("Earth", 5.97 * Math.pow(10,24), Color.blue, sun, 30300, 1.475 * Math.pow(10, 11));
		planets[2] = earth;
		Planet mars = new Planet("Mars", 6.42 * Math.pow(10,23), Color.red, sun, 26500, 2.066 * Math.pow(10, 11));
		planets[3] = mars;
		Planet jupiter = null;
		planets[4] = jupiter;
		Planet uranus = null;
		planets[5] = uranus;
		Planet neptune = null;
		planets[6] = neptune;
	}
	
	public void createStars(Star stars[])
	{
		for (int i = 0; i < stars.length; i++) {
			Star star = null;
			stars[i]=star;
		}
	}

	
	public void showCurrentSituation() {
	}

	
	public void moveInTime() {
	}

	
	
	
}

