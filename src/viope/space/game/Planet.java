package viope.space.game;

import java.awt.Color;

public class Planet extends Body
{	
	public Planet(String name, double mass, Color c, Body parent, double iVel, double peri)
	{
		super(name, mass, parent.getX(), parent.getY(), c);
		
		this.x = (int) (parent.getX() + (peri / Body.scale));
		this.y = parent.getY();
		this.xVel = 0;
		this.yVel = -1 * iVel;
	}
}
