package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JLabel; <- For Patrick and Ulisses

public class Creator 
{
	private ArrayList<Icon> objects = new ArrayList<Icon>();
	JFrame frame = new JFrame();
	JPanel view = new JPanel();
	JPanel buttons = new JPanel();
	JButton add = new JButton("Add");
	JButton remove = new JButton("Remove");
	JButton build = new JButton("Build");
	
	Icon one = new Icon(Color.red, 150, 150);
	Icon two = new Icon(Color.orange, 150, 150);
	Icon three = new Icon(Color.blue, 150, 150);
	Icon four = new Icon(Color.green, 150, 150);
	Icon five = new Icon(Color.yellow, 150, 150);
	Icon six = new Icon(Color.orange, 150, 150);
	Icon seven = new Icon(Color.white, 150, 150);
	Icon eight = new Icon(Color.cyan, 150, 150);
	Icon nine = new Icon(Color.magenta, 150, 150);
	
	public Creator()
	{
		frame.setSize(500, 500);
		frame.setLocationByPlatform(true);
		frame.setTitle("Edit Universe");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Main View
		objects.add(one);
		objects.add(two);
		objects.add(three);
		objects.add(four);
		objects.add(five);
		objects.add(six);
		objects.add(seven);
		objects.add(eight);
		objects.add(nine);
		
		for(Icon c : objects)
		{
			c.setPreferredSize(new Dimension(c.width, c.height));
		}
		
		view.setLayout(new GridLayout(3, 3, 5, 5));
		view.setBackground(Color.black);
		
		view.add(one);
		view.add(two);
		view.add(three);
		view.add(four);
		view.add(five);
		view.add(six);
		view.add(seven);
		view.add(eight);
		view.add(nine);
		
		//Listener for buttons
		add.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// What happens after pressing the button
						System.out.println("HERP DERP");
					}
				}
			);
		
		
		//Buttons
		buttons.setLayout(new GridLayout(1, 3, 10, 0));
		buttons.add(add);
		buttons.add(remove);
		buttons.add(build);
		
		//Frame
		Container main = frame.getContentPane();
		main.setBackground(Color.black);
		
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 10, 10, 10);
		main.add(view, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(10, 0, 0, 0);
		main.add(buttons, c);
		frame.pack();
	}
}
