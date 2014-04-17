package viope.space.game;

import java.awt.Color;

public class Planet extends Body 
{	
	public Planet(String name, double mass, Color c, int x, int y, double iVel, double peri) {
		super(name, mass, x, y, c);
		this.setX( (int)(x + (peri / Body.scale)) );
		
		this.xVel = 0;
		this.yVel = -1 * iVel;
	}
	
	public Planet(String name, double mass, Color c, Body parent, double iVel, double peri) {
		this(name, mass, c, parent.getX(), parent.getY(), iVel, peri);
	}
	
	
}

