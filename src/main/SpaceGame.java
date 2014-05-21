package main;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Scanner;

import javax.swing.JFrame;

public class SpaceGame {
	private static SpaceGUI spaceGUI;

	/**
	 * @param args
	 */
	public static void main(String[] args){
				
		spaceGUI = new SpaceGUI();
		// Asking data to user
		Scanner input=new Scanner(System.in);
		System.out.println(" - Set the initial velocity for the space ship - ");
		System.out.print("Velocity on the X-axis: ");
		BigDecimal xVel = input.nextBigDecimal();
		System.out.print("Velocity on the Y-axis: ");
		BigDecimal yVel = input.nextBigDecimal();
		input.close();
		// Creating the graphical part - BEHOLD HUMAN
		try {
		EventQueue.invokeAndWait(MainMenu.createMenu());
		} catch (Exception e) 
		{System.out.println("Hello derp"); return;}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame spaceFrame = new JFrame();
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				Container cp = spaceFrame.getContentPane();
				cp.setBackground(Color.black);
				spaceFrame.setSize(screenSize.width*10/7,screenSize.height*10/7);
				spaceFrame.setLocationByPlatform(true);
				spaceFrame.add(spaceGUI);
				spaceFrame.setTitle("Space Game");
				spaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				spaceFrame.setVisible(true);
			}
		});
		// Start the game
		Game game = new Game();
		game.setInitialVelocity(xVel, yVel);
		spaceGUI.setGame(game);
		game.setSpaceGUI(spaceGUI);
		game.runGame();
	}
	
}
