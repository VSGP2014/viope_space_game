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
		JButton start= new JButton("Start");
		Font font= new Font("Arial", 0, 32);
		
		//start.setBackground(Color.cyan);
		start.setFont(font);
		start.setSize(150, 50);
		JButton scores= new JButton("Scores");
		scores.setBorderPainted(false);
		scores.setSize(150,50);
		scores.setFont(font);
		
		frame.setPreferredSize(new Dimension(800,800));
		BufferedImage backGround=null;
		start.setLocation((frame.getPreferredSize().width/2)-(start.getSize().width/2), 400);
		scores.setLocation((frame.getPreferredSize().width/2)-(scores.getSize().width/2), (start.getLocation().y+start.getSize().height));
		
		//frame.setLayout(new GridLayout());
	       try {                
	           backGround = ImageIO.read(new File("C:\\Users\\formando\\Documents\\GitHub\\viope_space_game\\src\\main\\MainMenuBackGround.png"));
	        } catch (IOException ex) {
	             // handle exception...
	        }
	    JLabel picLabel = new JLabel(new ImageIcon(backGround));
	    picLabel.setLocation(0,0);
	    picLabel.setSize(frame.getPreferredSize());
	    frame.getContentPane().add(start);
	    frame.getContentPane().add(scores);
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
