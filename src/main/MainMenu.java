package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame{

	public MainMenu(){
		setTitle("SpaceGame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,800));
		
		JButton start= new JButton("Start");
		Font font= new Font("Arial", 0, 32);
		start.setFont(font);
		start.setSize(150, 50);
		start.setLocation((getPreferredSize().width/2)-(start.getSize().width/2), 400);
		
		JButton scores= new JButton("Scores");
		scores.setSize(150,50);
		scores.setFont(font);		
		scores.setLocation((getPreferredSize().width/2)-(scores.getSize().width/2), (start.getLocation().y+start.getSize().height));
		
		JButton about = new JButton("About");
		about.setFont(font);
		about.setSize(150,50);
		about.setLocation((getPreferredSize().width/2)-(about.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height));

		JButton quit = new JButton("Quit");
		quit.setFont(font);
		quit.setSize(150,50);
		quit.setLocation((getPreferredSize().width/2)-(quit.getSize().width/2), (start.getLocation().y+start.getSize().height+start.getSize().height+start.getSize().height));
		
		BufferedImage backGround=null;
	       try {                
	           backGround = ImageIO.read(getClass().getResource("background.jpg"));
	        } catch (IOException ex) {
	        	System.out.println("Herp derp no background");
	        }
	       
	    JLabel picLabel = new JLabel(new ImageIcon(backGround));
	    picLabel.setLocation(0,0);
	    picLabel.setSize(getPreferredSize());
	    getContentPane().add(start);
	    getContentPane().add(scores);
	    getContentPane().add(about);
	    getContentPane().add(quit);
	    getContentPane().add(picLabel);		
		getContentPane().setLayout(null);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public static Runnable createMenu()
	{
		return new Runnable()
		{
			public void run()
			{
				new MainMenu();
			}
		};
	}
}
