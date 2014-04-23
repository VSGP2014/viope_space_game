package viope.space.game;

import java.util.ArrayList;

public class Physics 
{
	/**
	 * The mathematical value of gravity constant. 
	 */
	static private double gravity = 6.67 * Math.pow(10,-11); // Will be moved in Constants
	
	/**
	 * The container of all the X axis forces.
	 */
	static public ArrayList<Double> XForces = new ArrayList<Double>();
	
	/**
	 * The container of all the Y axis forces.
	 */
	static public ArrayList<Double> YForces = new ArrayList<Double>();
	
	public static double force(Body subject, Body target) {
		return (gravity * subject.getMass() * target.getMass()) / (Math.pow(subject.getTargetDistance(target),2));
	}
	
	/**
	 * Method to easily sum an ArrayList of Doubles (as Forces).
	 * @param list The Double ArrayList to sum up.
	 * @return The sum of all the ArrayList Doubles.
	 */
	public static double sumForce(ArrayList<Double> list) {
		double sum = 0;
		for(Double d : list)
			sum += d;
		return sum;
	}
	
	/**
	 * Method to calculate the angle between two Bodies, using their X/Y.
	 * @param subject The starting Body.
	 * @param target The Body for which we calculate the angle.
	 * @return A double rappresenting the degrees of the angle.
	 */
	public static double getTheta(Body subject, Body target) {
		double theta = Math.atan((subject.getY() - target.getY()) / (target.getX() - subject.getX()));
		return Math.toDegrees(theta);
	}
	
	/**
	 * Method to calculate the net X force on a Body.
	 * @param subject The Body on which the Forces are acting.
	 * @return An ArrayList of Doubles with all the X forces on the Body subject. 
	 */
	public static ArrayList<Double> getNetXForce(Body subject) {
		int index = SolarSystem.universe.indexOf(subject);
		for(Body target : SolarSystem.universe)
		{
			if(SolarSystem.universe.indexOf(target) != index)
			{
				XForces.add(force(subject, target) * Math.cos(getTheta(subject, target)));
			}
		}
		return XForces;
	}
	
	/**
	 * Method to calculate the net Y force on a Body.
	 * @param subject The Body on which the Forces are acting.
	 * @return An ArrayList of Doubles with all the Y forces on the Body subject. 
	 */
	public static ArrayList<Double> getNetYForce(Body subject) {
		int index = SolarSystem.universe.indexOf(subject);
		for(Body target : SolarSystem.universe)
		{
			if(SolarSystem.universe.indexOf(target) != index)
			{
				YForces.add(force(subject, target) * Math.sin(getTheta(subject, target)));
			}
		}
		return YForces;
	}
	
	/**
	 * Method to clear the forces (so we can calculate forces for another Body).
	 * Actually, it's achieved by creating 2 new ArrayList (maybe will be changed...?)
	 * @see ArrayList
	 */
	public static void clearForces() {
		XForces = new ArrayList<Double>();
		YForces = new ArrayList<Double>();
	}
}
