package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;

import model.Body;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceGUI extends JPanel {
	
	private Game game;

	/**
	 * Create the panel.
	 */
	static double fuel = 100;
	static double origFuel;
	public SpaceGUI(){
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		KeyListener listener=new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
	}
	
	public void setFuel(double fuel){
		SpaceGUI.fuel=fuel;
		origFuel=fuel;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double x, y;
		double screenSize = Math.min(getWidth(),getHeight());
		for(Body body: game.getUniverse().getBodies()){
			g.setColor(body.getColor());
			x = ((((body.getLocation().getX()).divide(ConstantsUniverse.PLUTO_ORBIT,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND)).doubleValue())*screenSize + screenSize)/2.0+250.0;
			y = screenSize - (((((body.getLocation().getY()).divide(ConstantsUniverse.PLUTO_ORBIT,ConstantsSpaceGame.DECIMALS,ConstantsSpaceGame.ROUND)).doubleValue())*screenSize + screenSize)/2.0+50.0);
			int r = body.getSize();
			int d = (int)(r/2.0);
			g.fillOval((int)x-d,(int)y-d,r,r);
		}
		g.drawString("Fuel: "+Math.round((fuel/origFuel)*100)+"%", getWidth()-((getWidth()/100)*10), getHeight()-((getHeight()/100)*98));
	}

	public void setGame(Game game) {
		this.game = game;
	}

	
	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(fuel>0){
				fuel--;
				if(e.getKeyCode()==KeyEvent.VK_UP)
					game.accelerateSpaceShip(0);
				if(e.getKeyCode()==KeyEvent.VK_DOWN)
					game.accelerateSpaceShip(1);
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
					game.accelerateSpaceShip(2);
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					game.accelerateSpaceShip(3);
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
}
