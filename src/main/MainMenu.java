package main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu{

	private static void CreateMenu()
	{
		JFrame frame = new JFrame("SpaceGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,800));
		
		JButton start= new JButton("Start");
		Font font= new Font("Arial", 0, 32);
		start.setFont(font);
		start.setSize(150, 50);
		start.setLocation((frame.getPreferredSize().width/2)-(start.getSize().width/2), 400);
		
		JButton scores= new JButton("Scores");
		scores.setSize(150,50);
		scores.setFont(font);		
		scores.setLocation((frame.getPreferredSize().width/2)-(scores.getSize().width/2), (start.getLocation().y+start.getSize().height));
		
		JButton about = new JButton("About");
		about.setFont(font);
		about.setSize(150,50);
		about.setLocation((frame.getPreferredSize().width/2)-(about.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height));

		JButton quit = new JButton("Quit");
		quit.setFont(font);
		quit.setSize(150,50);
		quit.setLocation((frame.getPreferredSize().width/2)-(quit.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height+start.getSize().height));
		
		
		MainMenu menu = new MainMenu();
		BufferedImage backGround=null;
	       try {                
	           backGround = ImageIO.read(menu.getClass().getResource("background.jpg"));
	        } catch (IOException ex) {
	        }
	       
	    JLabel picLabel = new JLabel(new ImageIcon(backGround));
	    picLabel.setLocation(0,0);
	    picLabel.setSize(frame.getPreferredSize());
	    frame.getContentPane().add(start);
	    frame.getContentPane().add(scores);
	    frame.getContentPane().add(about);
	    frame.getContentPane().add(quit);
	    frame.getContentPane().add(picLabel);		
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(
				new Runnable() {
					public void run()
					{
						CreateMenu();
					}
				}
				);
		
	}
}
