import java.util.ArrayList;

public class Physics 
{
	static private double gravity = 6.67 * Math.pow(10,-11);
	static public ArrayList<Double> XForces = new ArrayList<Double>(); //Array to store all forces in X direction
	static public ArrayList<Double> YForces = new ArrayList<Double>(); //Array to store all forces in Y direction
	
	public static double force(Body subject, Body target)//WORKS 
	{
		double force = (gravity * subject.getMass() * target.getMass()) / (Math.pow(subject.getTargetDistance(target),2));
		return force;
	}
	
	public static double sumForce(ArrayList<Double> list)//WORKS
	{
		double sum = 0;
		
		for(Double d : list)
		{
			sum += d;
		}
		return sum;
	}
	
	public static double getTheta(Body subject, Body target)
	{
		double theta = Math.atan((subject.getY() - target.getY()) / (target.getX() - subject.getX()));
		return Math.toDegrees(theta);
	}
	
	public static ArrayList<Double> getNetXForce(Body subject)
	{
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
	
	public static void clearForces()
	{
		XForces = new ArrayList<Double>();
		YForces = new ArrayList<Double>();
	}
	
	public static ArrayList<Double> getNetYForce(Body subject)
	{
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
}
