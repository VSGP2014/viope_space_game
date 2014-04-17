package viope.space.game;

import java.awt.Color;

public class SpaceShip extends Body{

	private int energy;
	private boolean launched;
	private int max_speed;
	private int speed;
	
	public SpaceShip(String name, double mass, int x, int y, Color c, int energy, int max_speed) {
		super(name, mass, x, y, c);
		this.energy=energy;
		this.launched=false;
		this.max_speed=max_speed;
		this.speed=0;
	}
	
	public void launch() {
		launched=true;
	}
	
	public void update() {
		if(this.launched && (speed < max_speed)) {
			speed++;
			energy--;
		}
	}
}
