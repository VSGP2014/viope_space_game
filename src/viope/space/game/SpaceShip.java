package viope.space.game;

import java.awt.Color;

public class SpaceShip extends Body{

	private int energy;
	private boolean launched;
	
	public SpaceShip(String name, double mass, int x, int y, Color c, int energy) {
		super(name, mass, x, y, c);
		this.energy=energy;
		this.launched=false;
	}
	
	public void launch() {
		launched=true;
	}
	
	public void update(){
		if(this.launched){
			this.energy--;
		}
	}
}
