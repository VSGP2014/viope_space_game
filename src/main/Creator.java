package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SecondaryLoop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Creator
{
	private ArrayList<Icon> objects = new ArrayList<Icon>();
	JFrame frame = new JFrame();
	JPanel view = new JPanel();
	JPanel buttons = new JPanel();
	JPanel sliding = new JPanel();
	JButton backB = new JButton("Back");
	JButton defaultB = new JButton("Default");
	JButton buildB = new JButton("Build");
	JTextField slideText = new JTextField();
	JLabel name = new JLabel("Player Name: Player");
	JSlider slider = new JSlider(0,500,250);
	JLabel  fuelAmount= new JLabel("Fuel Quantity: " + slider.getValue());
	
	Icon one = new Icon(Color.red, 150, 150, 1);
	Icon two = new Icon(Color.orange, 150, 150, 2);
	Icon three = new Icon(Color.blue, 150, 150, 3);
	Icon four = new Icon(Color.green, 150, 150, 4);
	Icon five = new Icon(Color.yellow, 150, 150, 5);
	Icon six = new Icon(Color.orange, 150, 150, 6);
	Icon seven = new Icon(Color.white, 150, 150, 7);
	Icon eight = new Icon(Color.cyan, 150, 150, 8);
	Icon nine = new Icon(Color.magenta, 150, 150, 9);
	
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	EventQueue eq= toolkit.getSystemEventQueue();
	SecondaryLoop loop=eq.createSecondaryLoop();
    Thread worker = new WorkerThread();
	
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
			c.setPreferredSize(new Dimension(c.getWidth(), c.getHeight()));
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
		
		//Buttons
		buttons.setLayout(new GridLayout(1, 3, 10, 0));
		buttons.add(backB);
		buttons.add(defaultB);
		buttons.add(buildB);
		
		//Listener for buttons
		backB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				new MainMenu();
				frame.dispose();
				//System.out.println("Add button");
			}
		});
		
		defaultB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Default settings button");
			}
		});
		
		buildB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				System.out.println("Build button");
				worker.start();
		           if (!loop.enter()) {
		               // Report an error
		           }
			}
		});
		
		//Listeners for slider and textfield
		slider.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e) 
			{
				fuelAmount.setText("Fuel Amount: " + slider.getValue());
			}
		});
		
		slideText.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				name.setText("Player Name: " + slideText.getText());
			}
		});
	
		//Frame
		Container main = frame.getContentPane();
		main.setBackground(Color.black);
		
		main.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		//Slider
		sliding.setLayout(new GridBagLayout());
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(fuelAmount, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(slider, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(name, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(slideText, c);
		
		//Main frame
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(0, 10, 0, 10);
		main.add(view, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.weighty = 0.5;
		c.insets = new Insets(0, 0, 0, 0);
		main.add(buttons, c);

		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		main.add(sliding, c);
		
		frame.pack();
		}
	private static SpaceGUI spaceGUI;
	   class WorkerThread extends Thread {
	       @Override
	       public void run() {
				spaceGUI = new SpaceGUI();
				spaceGUI.setFuel(slider.getValue());
				// Start the game
				Game game = new Game();
				//game.setInitialVelocity(xVel, yVel);
				spaceGUI.setGame(game);
				game.setSpaceGUI(spaceGUI);
				JFrame spaceFrame = new JFrame();
				Dimension screenSize = new Dimension(800,800);
				Container cp = spaceFrame.getContentPane();
				cp.setBackground(Color.black);
				spaceFrame.setSize(screenSize.width*10/7,screenSize.height*10/7);
				spaceFrame.setLocationByPlatform(true);
				spaceFrame.add(spaceGUI);
				spaceFrame.setTitle("Space Game");
				spaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				spaceFrame.setVisible(true);
				game.runGame();
				// Return to the menu
				spaceFrame.dispose();
				EventQueue.invokeLater(MainMenu.createMenu());
				// Exit the loop
				loop.exit();
	       }
	   }

}
