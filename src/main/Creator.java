package main;

import model.Body;
import model.Universe;
import utils.ConstantsSpaceGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Creator extends JFrame
{
	private ArrayList<Icon> objects = new ArrayList<Icon>();
	boolean shift;
	public static Body start;
	public static Body end;
	JPanel view = new JPanel();
	JPanel buttons = new JPanel();
	JPanel sliding = new JPanel();
	JButton backB = new JButton("Back");
	JButton defaultB = new JButton("Default");
	JButton buildB = new JButton("Build");
	JTextField slideText = new JTextField();
	JLabel name = new JLabel("Player Name: Player");
	JSlider slider = new JSlider(0,500,250);
	JLabel  fuelAmount = new JLabel("Fuel Quantity: " + slider.getValue());
	public static JLabel startBody = new JLabel("Start: ");
	public static JLabel endBody = new JLabel("End: ");
	

	
	Universe tempUni = new Universe();
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	EventQueue eq= toolkit.getSystemEventQueue();
	SecondaryLoop loop=eq.createSecondaryLoop();
    Thread worker = new WorkerThread();
	
	public Creator()
	{
		SolarSystem.populate();
		start = SolarSystem.body[3];
		end = SolarSystem.body[4];
		startBody.setText("Start: " + Creator.start.getName());
		endBody.setText("End: " + end.getName());
		//Images
		BufferedImage mercury = null;
		BufferedImage venus = null;
		BufferedImage earth = null;
		BufferedImage mars = null;
		BufferedImage jupiter = null;
		BufferedImage saturn = null;
		BufferedImage uranus = null;
		BufferedImage neptune = null;
		BufferedImage sun = null;
		
		try{
			mercury = ImageIO.read(getClass().getResource("planets/mercury.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			venus = ImageIO.read(getClass().getResource("planets/venus.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			earth = ImageIO.read(getClass().getResource("planets/earth.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			mars = ImageIO.read(getClass().getResource("planets/mars.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			jupiter = ImageIO.read(getClass().getResource("planets/jupiter.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			saturn = ImageIO.read(getClass().getResource("planets/saturn.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			uranus = ImageIO.read(getClass().getResource("planets/uranus.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			neptune = ImageIO.read(getClass().getResource("planets/neptune.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		try{
			sun = ImageIO.read(getClass().getResource("planets/sun.png"));
		}
		catch (IOException ex) {
		System.out.println("Herp derp no image");
		}
		
		Icon one = new Icon(Color.red, sun, 150, 150, 0);
		Icon two = new Icon(Color.orange, mercury, 150, 150, 1);
		Icon three = new Icon(Color.blue, venus, 150, 150, 2);
		Icon four = new Icon(Color.green, earth, 150, 150, 3);
		Icon five = new Icon(Color.yellow, mars, 150, 150, 4);
		Icon six = new Icon(Color.orange, jupiter, 150, 150, 5);
		Icon seven = new Icon(Color.white, saturn, 150, 150, 6);
		Icon eight = new Icon(Color.cyan, uranus, 150, 150, 7);
		Icon nine = new Icon(Color.magenta, neptune, 150, 150, 8);
		
		this.shift = false;
		
		setSize(500, 500);
		setLocationByPlatform(true);
		setTitle("Edit Universe");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
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
				dispose();
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
				dispose();
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
				ConstantsSpaceGame.PLAYER = slideText.getText();
				name.setText("Player Name: " + ConstantsSpaceGame.PLAYER);
			}
		});
		
		//Listener for Shift Key
		
		addKeyListener(new KeyAdapter(){
			
			public void keyPressed(KeyEvent e) 
			{
				System.out.println("You pressed a button");
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					Creator.this.shift = true;
					System.out.println("Shift is Pressed");
				}
			}

			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					Creator.this.shift = false;
					System.out.println("Shift is Released");
				}
			}

			public void keyTyped(KeyEvent e) 
			{

			}
		});
	
		//Frame
		Container main = getContentPane();
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
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(startBody, c);
		
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(5, 10, 5, 10);
		sliding.add(endBody, c);
		
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
		
		pack();
	}
	
	private static SpaceGUI spaceGUI;
	   class WorkerThread extends Thread {
	       @Override
	       public void run() {
				spaceGUI = new SpaceGUI();
				spaceGUI.setFuel(slider.getValue()*20);
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
