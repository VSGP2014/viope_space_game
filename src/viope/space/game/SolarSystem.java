package viope.space.game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Margarida & Monica
 * This class should contain all the stuff needed for creating a virtual copy of our solar system.
 */
public class SolarSystem {
	final static int NUM_PLANETS=7, NUM_MAX_STARS=100, UNIVERSE_DIMENSION = 1000000;
	static ArrayList<Body> universe = new ArrayList<Body>();
	static Body sun = new Body("Sun", 1.99 * Math.pow(10, 30), 400, 400, Color.yellow);
	static Planet planets[] = new Planet[NUM_PLANETS];
	static Star stars[] = new Star[NUM_MAX_STARS];
	
	public SolarSystem() {
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
	
	public Planet[] getPlanets() {
		return planets;
	}
	
	public void createPlanets(Planet planets[]) {
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
	
	public void createStars(Star stars[]) {
		Random randomXY = new Random();
		int x, y;
		
		for (int i = 0; i < stars.length; i++) {
			
			x = randomXY.nextInt(UNIVERSE_DIMENSION);
			if(Math.random() < 0.5){
				x = -x;   //having the universe negative and positive number, we randomly choose one of the two. in this case the number has been randomly set to negative
			}

			y= randomXY.nextInt(UNIVERSE_DIMENSION);
			if(Math.random() < 0.5){
				y = -y;
			}
			
			boolean xyOccupied = false;
			
			for (int j = 0; j < planets.length; j++) {
				if(planets[j].getX() == x && planets[j].getY() == y) {
					xyOccupied = true; //check if any planet its in the same position of the randomed x and y;
				}
			}
			
			if(sun.getX() == x && sun.getY() == y){
				xyOccupied = true;
			}
			
			if(xyOccupied) {
				--i;   //if the position of the object is already occupied, the next iteration of the while recreate the object;
			} else {
				stars[i] = new Star("Star "+(i+1),1,x,y,Color.gray,0);
			}

		}
	}

	
	public void showCurrentSituation() {
	}

	
	public void moveInTime() {
	}

	
	
	
}

