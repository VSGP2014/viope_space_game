import java.awt.Color;
import java.util.ArrayList;

public class SolarSystem 
{
	static ArrayList<Body> universe = new ArrayList<Body>();
	static Body sun = new Body("Sun", 1.99 * Math.pow(10, 30), 400, 400, Color.yellow);
	static Planet earth = new Planet("Earth", 5.97 * Math.pow(10,24), Color.blue, sun, 30300, 1.475 * Math.pow(10, 11));
	static Planet mars = new Planet("Mars", 6.42 * Math.pow(10,23), Color.red, sun, 26500, 2.066 * Math.pow(10, 11));
	
	public SolarSystem()
	{
		universe.add(sun);
		universe.add(earth);
		universe.add(mars);
	}
}

