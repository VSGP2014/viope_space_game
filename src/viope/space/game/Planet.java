package viope.space.game;

import java.awt.Color;

public class Planet extends Body
{	
	public Planet(String name, double mass, Color c, int x, int y, double iVel, double peri)
	{
		x = (int)(x + (peri / Body.scale));
		super(name, mass, x, y, c);
		
		this.xVel = 0;
		this.yVel = -1 * iVel;
	}
}
