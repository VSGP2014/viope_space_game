package viope.space.game;

import java.awt.Color;

public class SpaceShip extends Body {

	private int energy;
	private boolean launched;
	private int max_speed;
	private int speed;
	private float direction;
	
	public SpaceShip(String name, double mass, int x, int y, Color c, int energy, int max_speed) {
		super(name, mass, x, y, c);
		this.energy=energy;
		this.launched=false;
		this.max_speed=max_speed;
		this.speed=0;
		this.direction=0;
	}
	
	public void launch(float direction) {
		launched=true;
		this.direction=direction;
	}
	
	public void setLaunchPos(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public void update() {
		if(this.launched) {
			this.setX(getX()+(int)this.getXVel());
			this.setY(this.getY()+(int)this.getYVel());
			if(speed < max_speed && energy > 0) {
				speed++;
				energy--;
			}
		}
	}
	public int situation()
	{
		//TODO
		if(this.launched)
		{		
			if(energy==0)
				return 1;  //energy finished
			if()
				return 2;  	// planet hit
			if()
				return 3; 	//arrived destination	
			return 0;  		//ok
		}
		return -1;		//not launched yet
	}
}
