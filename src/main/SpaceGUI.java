package main;

import java.awt.Graphics;
import java.math.BigDecimal;

import javax.swing.JPanel;

import utils.ConstantsSpaceGame;
import utils.ConstantsUniverse;
import utils.Vector;

import model.Universe;
import model.Body;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class SpaceGUI extends JPanel {
	
	private Game game;

	/**
	 * Create the panel.
	 */
	
	public SpaceGUI(){
		//setBackground(new Color(0, 51, 102));
		setBackground(new Color(0, 0, 0));
		setLayout(null);	
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
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
