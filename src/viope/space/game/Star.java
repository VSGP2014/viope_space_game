package viope.space.game;

import java.awt.Color;

public class Star extends Body{
	
	private int temperature;
	private int diameter; // Won't use it for now

	public Star(String name, double mass, int x, int y, Color c, int temperature) {
		super(name, mass, x, y, c);
		this.temperature=temperature;
	}

}
