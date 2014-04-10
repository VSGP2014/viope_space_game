package viope.space.game;

import java.awt.Color;

public class SpaceShip extends Body{

	private int energy;
	private boolean launched;
	
	public SpaceShip(double mass, int x, int y, Color c, int energy) {
		super(mass, x, y, c);
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
