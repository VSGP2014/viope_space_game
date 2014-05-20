package main;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Editor extends JFrame
{
	JFrame frame;
	JLabel name = new JLabel("Name:");
	JLabel dist = new JLabel("Distance:");
	JLabel mass = new JLabel("Mass:");
	JLabel vel = new JLabel("Vel:");
	JLabel color = new JLabel("Color:");
	
	JTextField nameX = new JTextField(20);
	JTextField massX = new JTextField(20);
	JTextField velX = new JTextField(20);
	JTextField distX = new JTextField(20);
	
	Color[] colors = {Color.red, Color.orange, Color.blue, Color.green, Color.yellow, Color.white, Color.cyan, Color.magenta};
	
	ImageIcon blue = new ImageIcon(getClass().getResource("Blue.png"), "Blue");
	ImageIcon cyan = new ImageIcon(getClass().getResource("Cyan.png"), "Cyan");
	ImageIcon green = new ImageIcon(getClass().getResource("Green.png"), "Green");
	ImageIcon magenta = new ImageIcon(getClass().getResource("Magenta.png"), "Magenta");
	ImageIcon orange = new ImageIcon(getClass().getResource("Orange.png"), "Orange");
	ImageIcon red = new ImageIcon(getClass().getResource("Red.png"), "Red");
	ImageIcon white = new ImageIcon(getClass().getResource("White.png"), "White");
	ImageIcon yellow = new ImageIcon(getClass().getResource("Yellow.png"), "Yellow");
	
	//ImageIcon[] colorPic = {yellow};
	ImageIcon[] colorPic = {blue, cyan, green, magenta, orange, red, white, yellow};
	JComboBox colorX = new JComboBox(colorPic);
	
	JPanel commitPanel = new JPanel();
	JButton commit = new JButton("Commit");
	
	public Editor()
	{
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocation(600, 200);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setTitle("Editor");
		frame.setVisible(true);
		
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Commit Button
		commitPanel.setLayout(new GridBagLayout());
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 10, 10, 10);
		commitPanel.add(commit, c);
		
		//Labels
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 5, 0, 0);
		frame.add(name, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 5, 0, 0);
		frame.add(dist, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 5, 0, 0);
		frame.add(mass, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 5, 0, 0);
		frame.add(vel, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 5, 0, 0);
		frame.add(color, c);
		
		//Textfields
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 0, 0);
		frame.add(nameX, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 0, 0);
		frame.add(distX, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 0, 0);
		frame.add(massX, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 0, 0);
		frame.add(velX, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 10, 0, 0);
		frame.add(colorX, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 0, 0, 0);
		frame.add(commitPanel, c);
		frame.pack();
	}
}
