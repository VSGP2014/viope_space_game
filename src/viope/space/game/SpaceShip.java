package viope.space.game;

import java.awt.Color;

public class SpaceShip extends Body{

	private int energy;
	private boolean launched=false;
	public SpaceShip(double mass, int x, int y, Color c, int energy) {
		super(mass, x, y, c);
		this.energy=energy;
		
	}
	public void Launch()
	{
		launched=true;
	}
	public void update()
	{
		if(launched)
		{
			this.energy--;
		}
	}
}
